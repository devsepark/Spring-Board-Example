package devsepark.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.common.SearchVo;
import devsepark.board.model.BoardArticle;
import devsepark.board.model.BoardComment;
import devsepark.board.model.BoardGroup;
import devsepark.board.model.UserDetailsVo;
import devsepark.board.service.BoardGroupService;
import devsepark.board.service.BoardArticleService;
import devsepark.board.service.BoardCommentService;

//게시판 컨트롤러, /board를 기본 경로로 매핑.
@Controller
@RequestMapping("/board")
public class BoardArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardArticleController.class);
	
	@Autowired
	private BoardArticleService boardArticleService;	//게시판 서비스
	@Autowired
	private BoardGroupService boardGroupService;		//게시판 그룹 서비스
	@Autowired
	private BoardCommentService boardCommentService;	//게시판 댓글 서비스
	
	
	
	//리스트 페이지
	@RequestMapping(value = "/{boardName}", method = RequestMethod.GET )
	public String boardArticleList(@PathVariable("boardName") String boardName, SearchVo searchVo, ModelMap modelMap) {
		
		BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardName);
		if(boardGroup == null) {
			System.out.println("boardId : " + boardName);
			//TODO return 404error page
		}
		searchVo.setGroupId(boardGroup.getId());
		//페이징 처리
		searchVo.pageCalculate(boardArticleService.selectBoardCount(searchVo)); 
		//보여지는 페이지만큼 게시글 셀렉트
		List<BoardArticle> articleList = boardArticleService.selectBoardList(searchVo);
		//JSP로 전달
		modelMap.addAttribute("articleList", articleList);
		modelMap.addAttribute("searchVo", searchVo);
		modelMap.addAttribute("boardGroup", boardGroup);
		
		logger.info("Board Article list,URL=/board/{},Method=GET",boardName);
		
		return  "/board/board_list";
	}
	
	//글쓰기 폼 페이지
    @RequestMapping(value = "/{boardName}/form", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
   	public String boardArticleForm(@PathVariable("boardName") String boardName, ModelMap modelMap) {
    	
    	BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardName);
		if(boardGroup == null) {
			//TODO return 404error page
		}
		modelMap.addAttribute("boardGroup", boardGroup);
		
		logger.info("Board Article form,URL=/board/{},Method=GET",boardName);
		
        return "/board/board_form";
    }
    
    //글 저장, ModelAttribute로 게시판 객체를 받아 DB에 삽입.
    @RequestMapping(value = "/{boardName}", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
   	public String boardArticleSave(@PathVariable("boardName") String boardName, @ModelAttribute BoardArticle board, Authentication auth) {
    	
    	BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardName);
		if(boardGroup == null) {
			//TODO return 404error page
		}
		board.setGroupId(boardGroup.getId());
		UserDetailsVo user = (UserDetailsVo) auth.getPrincipal();
		board.setWriter(user.getName());
    	boardArticleService.insertBoard(board);
    	
    	logger.info("Board Article Save,URL=/board/{},Method=POST,UserName={},ArticleID={}",boardName,user.getName(),board.getId());
    	
        return "redirect:/board/"+boardName;
    }
    
    //글 수정 페이지
    @RequestMapping(value = "/{boardName}/article/{articleId}/form", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
   	public String boardUpdateForm(@PathVariable("boardName") String boardName
   			, @PathVariable("articleId") String articleId, ModelMap modelMap) {
    	
    	BoardArticle article = boardArticleService.selectBoardOne(articleId);
        if(article == null) {
        	//TODO return 404error page.
        }
        BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardName);
		if(boardGroup == null) {
			//TODO return 404error page
		}
		
    	modelMap.addAttribute("boardArticle", article);
    	modelMap.addAttribute("boardGroup", boardGroup);
    	
        return "/board/board_update";
    }
    
    //글 수정 저장
    @RequestMapping(value = "/{boardName}/article/{articleId}", method = RequestMethod.PUT)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
   	public String boardUpdateSave(@PathVariable("boardName") String boardName
   			, @PathVariable("articleId") String articleId, @ModelAttribute BoardArticle article) {
    	
    	boardArticleService.updateBoard(article);
    	
        return "redirect:/board/"+boardName+"/article/"+articleId;
    }

    //글 읽기 페이지, 게시판과 게시글 ID를 Path에서 받아 게시글을 조회.
    @RequestMapping(value = "/{boardName}/article/{articleId}", method = RequestMethod.GET)
   	public String boardRead(@PathVariable("boardName") String boardName
   			, @PathVariable("articleId") String articleId, ModelMap modelMap) {
    	
    	BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardName);
		if(boardGroup == null) {
			//TODO return 404error page
		}
		
    	BoardArticle article = boardArticleService.selectBoardOne(articleId);
    	if(article == null) {
    		//TODO return 404error page
    	}
    	List<BoardComment> commentList = boardCommentService.selectBoardCommentList(articleId);
    	
    	
    	modelMap.addAttribute("boardArticle", article);
    	modelMap.addAttribute("boardGroup", boardGroup);
    	modelMap.addAttribute("commentList", commentList);
    	//조회수 증가
    	boardArticleService.updateBoardHit(articleId);
    	
    	logger.info("Board Article Read,URL=/board/{}/article/{},Method=GET",boardName,articleId);
    	
        return "/board/board_read";
    }
    
    //글 삭제
    @RequestMapping(value = "/{boardName}/article/{articleId}", method = RequestMethod.DELETE)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
   	public String boardDelete(@PathVariable("boardName") String boardName, @PathVariable("articleId") String articleId) {
    	
    	boardArticleService.deleteBoardOne(articleId);
        
    	logger.info("Board Article Delete,URL=/board/{}/article/{},Method=DELETE",boardName,articleId);
    	
        return "redirect:/board/" + boardName;
    }
}
