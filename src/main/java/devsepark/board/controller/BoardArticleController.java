package devsepark.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import devsepark.board.service.BoardGroupService;
import devsepark.board.service.BoardArticleService;
import devsepark.board.service.BoardCommentService;

//게시판 컨트롤러, /board를 기본 경로로 매핑.
@Controller
@RequestMapping("/board")
public class BoardArticleController {
	@Autowired
	private BoardArticleService boardArticleService;	//게시판 서비스
	@Autowired
	private BoardGroupService boardGroupService;		//게시판 그룹 서비스
	@Autowired
	private BoardCommentService boardCommentService;
	
	//리스트 페이지
	@RequestMapping(value = "/{boardid}", method = RequestMethod.GET )
	public String boardList(@PathVariable("boardid") String boardid, SearchVo searchVo, ModelMap modelMap) {
		
		BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardid);
		if(boardGroup == null) {
			System.out.println("boardid : " + boardid);
			//TODO return 404error page
		}
		searchVo.setGroupid(boardGroup.getId());
		//페이징 처리
		searchVo.pageCalculate(boardArticleService.selectBoardCount(searchVo)); 
		//보여지는 페이지만큼 게시글 셀렉트
		List<BoardArticle> articleList = boardArticleService.selectBoardList(searchVo);
		//JSP로 전달
		modelMap.addAttribute("articleList", articleList);
		modelMap.addAttribute("searchVo", searchVo);
		modelMap.addAttribute("boardGroup", boardGroup);
		return  "/board/board_list";
	}
	
	//글쓰기 폼 페이지
    @RequestMapping(value = "/{boardid}/form", method = RequestMethod.GET)
   	public String boardForm(@PathVariable("boardid") String boardid, ModelMap modelMap) {
    	
    	BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardid);
		if(boardGroup == null) {
			//TODO return 404error page
		}
		modelMap.addAttribute("boardGroup", boardGroup);
		
        return "/board/board_form";
    }
    
    //글 저장, ModelAttribute로 게시판 객체를 받아 db에 삽입.
    @RequestMapping(value = "/{boardid}", method = RequestMethod.POST)
   	public String boardSave(@PathVariable("boardid") String boardid, @ModelAttribute BoardArticle board) {
    	
    	BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardid);
		if(boardGroup == null) {
			//TODO return 404error page
		}
		board.setGroupid(boardGroup.getId());
    	boardArticleService.insertBoard(board);
    	
        return "redirect:/board/"+boardid;
    }
    
    //글 수정 페이지
    @RequestMapping(value = "/{boardid}/article/{articleid}/form", method = RequestMethod.GET)
   	public String boardUpdateForm(@PathVariable("boardid") String boardid
   			, @PathVariable("articleid") String articleid, ModelMap modelMap) {
    	
    	BoardArticle article = boardArticleService.selectBoardOne(articleid);
        if(article == null) {
        	//TODO return 404error page.
        }
        BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardid);
		if(boardGroup == null) {
			//TODO return 404error page
		}
		
    	modelMap.addAttribute("boardArticle", article);
    	modelMap.addAttribute("boardGroup", boardGroup);
    	
        return "/board/board_update";
    }
    
    //글 수정 저장
    @RequestMapping(value = "/{boardid}/article/{articleid}", method = RequestMethod.PUT)
   	public String boardUpdateSave(@PathVariable("boardid") String boardid
   			, @PathVariable("articleid") String articleid, @ModelAttribute BoardArticle article) {
    	
    	boardArticleService.updateBoard(article);
    	
        return "redirect:/board/"+boardid+"/article/"+articleid;
    }

    //글 읽기 페이지, 게시판과 게시글 ID를 Path에서 받아 게시글을 조회.
    @RequestMapping(value = "/{boardid}/article/{articleid}", method = RequestMethod.GET)
   	public String boardRead(@PathVariable("boardid") String boardid
   			, @PathVariable("articleid") String articleid, ModelMap modelMap) {
    	
    	BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardid);
		if(boardGroup == null) {
			//TODO return 404error page
		}
		
    	BoardArticle article = boardArticleService.selectBoardOne(articleid);
    	if(article == null) {
    		//TODO return 404error page
    	}
    	List<BoardComment> commentList = boardCommentService.selectBoardCommentList(articleid);
    	
    	
    	modelMap.addAttribute("boardArticle", article);
    	modelMap.addAttribute("boardGroup", boardGroup);
    	modelMap.addAttribute("commentList", commentList);
    	//조회수 증가
    	boardArticleService.updateBoardHit(articleid);
        return "/board/board_read";
    }
    
    //글 삭제
    @RequestMapping(value = "/{boardid}/article/{articleid}", method = RequestMethod.DELETE)
   	public String boardDelete(@PathVariable("articleid") String articleid) {
    	
    	boardArticleService.deleteBoardOne(articleid);
        
        return "redirect:/board/tip";
    }
}
