package devsepark.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.model.BoardTip;
import devsepark.board.service.BoardTipService;


@Controller
@RequestMapping("/board/tip")
public class BoardTipController {
	@Autowired
	private BoardTipService boardTipService;
	
	//리스트
	@RequestMapping(value = "", method = RequestMethod.GET )
	public String boardTipList(ModelMap modelMap) {
		List<?> list = boardTipService.selectBoardList();
		
		modelMap.addAttribute("list", list);
		return  "/board_tip/board_list";
	}
	
	//글쓰기 폼
    @RequestMapping(value = "/form", method = RequestMethod.GET)
   	public String boardForm() {
        return "/board_tip/board_form";
    }
    
    //글 저장
    @RequestMapping(value = "", method = RequestMethod.POST)
   	public String boardSave(@ModelAttribute BoardTip boardTip) {
    	
    	boardTipService.insertBoard(boardTip);
    	
        return "redirect:/board/tip";
    }
    
    // 글 수정
    @RequestMapping(value = "/article/{id}/form", method = RequestMethod.GET)
   	public String boardUpdate(@PathVariable String id, ModelMap modelMap) {
    	
    	BoardTip boardTip = boardTipService.selectBoardOne(id);
        
    	modelMap.addAttribute("boardTip", boardTip);
    	
        return "/board_tip/board_update";
    }
    
    //글 수정 저장
    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT)
   	public String boardUpdateSave(@ModelAttribute BoardTip boardTip) {
    	
    	boardTipService.updateBoard(boardTip);
    	
        return "redirect:/board/tip";
    }    

    // 글 읽기
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
   	public String boardRead(@PathVariable String id, ModelMap modelMap) {
    	
    	BoardTip boardTip = boardTipService.selectBoardOne(id);
        
    	modelMap.addAttribute("boardTip", boardTip);
    	
        return "/board_tip/board_read";
    }
    
    // 글 삭제
    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
   	public String boardDelete(@PathVariable String id) {
    	
    	boardTipService.deleteBoardOne(id);
        
        return "redirect:/board/tip";
    }
}