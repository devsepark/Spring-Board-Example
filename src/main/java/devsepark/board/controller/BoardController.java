package devsepark.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.common.CommentVo;
import devsepark.board.common.SearchVo;
import devsepark.board.model.Board;
import devsepark.board.model.BoardGroup;
import devsepark.board.service.BoardGroupService;
import devsepark.board.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardGroupService boardGroupService;
	
	//리스트 페이지
	@RequestMapping(value = "/{boardid}", method = RequestMethod.GET )
	public String boardTipList(@PathVariable("boardid") String boardid, SearchVo searchVo, ModelMap modelMap) {
		
		BoardGroup boardGroup = boardGroupService.selectBoardGroupOne(boardid);
		if(boardGroup == null) {
			//TODO return 404error
		}
		
		searchVo.pageCalculate(boardService.selectBoardCount(searchVo)); 
		
		List<?> boardList = boardService.selectBoardList(searchVo);
		
		modelMap.addAttribute("boardList", boardList);
		modelMap.addAttribute("pageVo", searchVo);
		modelMap.addAttribute("boardGroup", boardGroup);
		return  "/board/board_list";
	}
	
	//글쓰기 폼 페이지
    @RequestMapping(value = "/{boardid}/form", method = RequestMethod.GET)
   	public String boardForm(@PathVariable String boardid) {
        return "/board/board_form";
    }
    
    //글 저장
    @RequestMapping(value = "/{boardid}", method = RequestMethod.POST)
   	public String boardSave(@PathVariable String boardid, @ModelAttribute Board boardTip) {
    	
    	boardService.insertBoard(boardTip);
    	
        return "redirect:/board/tip";
    }
    
    @RequestMapping(value = "/article/{articleid}/comment", method = RequestMethod.POST)
    public String boardReplySave(CommentVo commentVo) {
        
    	boardService.insertBoardReply(commentVo);

        return "redirect:/board/tip/article/" + commentVo.getBoardid();
    }

    
    //글 수정 페이지
    @RequestMapping(value = "/article/{articleid}/form", method = RequestMethod.GET)
   	public String boardUpdateForm(@PathVariable String articleid, ModelMap modelMap) {
    	
    	Board boardTip = boardService.selectBoardOne(articleid);
        
    	modelMap.addAttribute("boardTip", boardTip);
    	
        return "/board_tip/board_update";
    }
    
    //글 수정 저장
    @RequestMapping(value = "/article/{articleid}", method = RequestMethod.PUT)
   	public String boardUpdateSave(@ModelAttribute Board boardTip) {
    	
    	boardService.updateBoard(boardTip);
    	
        return "redirect:/board/tip";
    }    

    //글 읽기 페이지
    @RequestMapping(value = "{boardid}/article/{articleid}", method = RequestMethod.GET)
   	public String boardRead(@PathVariable("boardid") String boardid, @PathVariable("articleid") String articleid, ModelMap modelMap) {
    	
    	Board board = boardService.selectBoardOne(articleid);
    	modelMap.addAttribute("board", board);
    	//조회수 증가
    	boardService.updateBoardHit(articleid);
        return "/board/board_read";
    }
    
    //글 삭제
    @RequestMapping(value = "/article/{articleid}", method = RequestMethod.DELETE)
   	public String boardDelete(@PathVariable String articleid) {
    	
    	boardService.deleteBoardOne(articleid);
        
        return "redirect:/board/tip";
    }
}
