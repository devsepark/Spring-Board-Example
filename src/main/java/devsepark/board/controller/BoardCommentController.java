package devsepark.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.model.BoardComment;
import devsepark.board.model.UserDetailsVo;
import devsepark.board.service.BoardCommentService;

@Controller
@RequestMapping("/board")
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardCommentService;	//게시판 서비스
	
	//댓글 저장
    @RequestMapping(value = "/{boardName}/article/{articleId}/comment", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String boardCommentSave(@PathVariable("boardName") String boardName
    		, @PathVariable("articleId") String articleId, BoardComment commentVo, Authentication auth) {
    	
		UserDetailsVo user = (UserDetailsVo) auth.getPrincipal();
		commentVo.setWriter(user.getName());
    	boardCommentService.insertBoardComment(commentVo);
    	
    	
        return "redirect:/board/"+boardName+"/article/"+articleId;
    }
    //댓글 수정
    @RequestMapping(value = "/{boardName}/article/{articleId}/comment/{commentId}", method = RequestMethod.PUT)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String boardCommentUpdate(@PathVariable("boardName") String boardName, @PathVariable("articleId") String articleId
    		, @PathVariable("commentId") String commentId, BoardComment commentVo) {
        
    	boardCommentService.updateBoardComment(commentVo);
    	
        return "redirect:/board/"+boardName+"/article/"+articleId;
    }
    //댓글 삭제
    @RequestMapping(value = "/{boardName}/article/{articleId}/comment/{commentId}", method = RequestMethod.DELETE)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String boardCommentDelete(@PathVariable("boardName") String boardName, @PathVariable("articleId") String articleId
    		, @PathVariable("commentId") String commentId) {
    	
    	boardCommentService.deleteBoardComment(commentId);
    	
    	return "redirect:/board/" + boardName + "/article/" + articleId;
    }
}
