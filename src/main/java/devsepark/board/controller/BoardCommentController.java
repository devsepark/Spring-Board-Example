package devsepark.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.model.BoardComment;
import devsepark.board.service.BoardCommentService;

@Controller
@RequestMapping("/board")
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardCommentService;	//게시판 서비스
	
	//댓글 저장
    @RequestMapping(value = "/{boardname}/article/{articleid}/comment", method = RequestMethod.POST)
    public String boardCommentSave(@PathVariable("boardname") String boardname
    		, @PathVariable("articleid") String articleid, BoardComment commentVo) {
        
    	boardCommentService.insertBoardComment(commentVo);
    	
        return "redirect:/board/"+boardname+"/article/"+articleid;
    }
    //댓글 수정
    @RequestMapping(value = "/{boardname}/article/{articleid}/comment/{commentid}", method = RequestMethod.PUT)
    public String boardCommentUpdate(@PathVariable("boardname") String boardname, @PathVariable("articleid") String articleid
    		, @PathVariable("commentid") String commentid, BoardComment commentVo) {
        
    	boardCommentService.updateBoardComment(commentVo);
    	
        return "redirect:/board/"+boardname+"/article/"+articleid;
    }
    //댓글 삭제
    @RequestMapping(value = "/{boardname}/article/{articleid}/comment/{commentid}", method = RequestMethod.DELETE)
    public String boardCommentDelete(@PathVariable("boardname") String boardname, @PathVariable("articleid") String articleid
    		, @PathVariable("commentid") String commentid) {
    	
    	boardCommentService.deleteBoardComment(commentid);
    	
    	return "redirect:/board/" + boardname + "/article/" + articleid;
    }
}
