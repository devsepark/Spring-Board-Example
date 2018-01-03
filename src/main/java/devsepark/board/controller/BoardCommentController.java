package devsepark.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.model.BoardComment;
import devsepark.board.service.BoardCommentService;

@Controller
@RequestMapping("/board")
public class BoardCommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentController.class);
	
	@Autowired
	private BoardCommentService boardCommentService;	//게시판 서비스
	
	//댓글 저장
    @RequestMapping(value = "/{boardName}/article/{articleId}/comment", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String commentSave(@PathVariable("boardName") String boardName
    		, @PathVariable("articleId") String articleId, @ModelAttribute BoardComment commentVo, Authentication auth) {
    	
		UserDetails user = (UserDetails) auth.getPrincipal();
		commentVo.setWriter(user.getUsername());
    	boardCommentService.insertBoardComment(commentVo);
    	
    	logger.info("Board Comment Save,URL=/board/{}/article/{}/comment,Method=POST",boardName,articleId);
    	
        return "redirect:/board/"+boardName+"/article/"+articleId;
    }
    //댓글 수정
    @RequestMapping(value = "/{boardName}/article/{articleId}/comment/{commentId}", method = RequestMethod.PUT)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String commentUpdate(@PathVariable("boardName") String boardName, @PathVariable("articleId") String articleId
    		, @PathVariable("commentId") String commentId, BoardComment commentVo) {
        
    	boardCommentService.updateBoardComment(commentVo);
    	
    	logger.info("Board Comment Update,URL=/board/{}/article/{}/comment/{},Method=PUT",boardName,articleId, commentId);
    	
        return "redirect:/board/"+boardName+"/article/"+articleId;
    }
    //댓글 삭제
    @RequestMapping(value = "/{boardName}/article/{articleId}/comment/{commentId}", method = RequestMethod.DELETE)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String commentDelete(@PathVariable("boardName") String boardName, @PathVariable("articleId") String articleId
    		, @PathVariable("commentId") String commentId) {
    	
    	boardCommentService.deleteBoardComment(commentId);
    	
    	logger.info("Board Comment Delete,URL=/board/{}/article/{}/comment/{},Method=DELETE",boardName,articleId,commentId);
    	
    	return "redirect:/board/" + boardName + "/article/" + articleId;
    }
}
