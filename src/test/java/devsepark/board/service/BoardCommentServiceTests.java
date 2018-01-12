package devsepark.board.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import devsepark.board.model.BoardArticle;
import devsepark.board.model.BoardComment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/context-*.xml",
		"classpath:/config/*-servlet.xml"})
@WebAppConfiguration
public class BoardCommentServiceTests {
	
	@Autowired
	private BoardCommentService commentService;
	@Autowired
	private BoardArticleService articleService;
	
	private BoardComment boardComment;
	
	private BoardArticle testArticle;
	
	@Before
	@Transactional
	public void setUp() {
		BoardArticle article = new BoardArticle();
		article.setWriter("TestUser");
		article.setTitle("TestTitle");
		article.setContent("TestContent");
		article.setGroupId("1");
		articleService.insertArticle(article);
		
		testArticle = articleService.selectRecentArticle();
		
		boardComment = new BoardComment();
		boardComment.setArticleId(testArticle.getId());
		boardComment.setWriter("CommentWriterTest");
		boardComment.setContent("CommentContentTest");
	}
	
	@Test
	@Transactional
	public void insertBoardCommentTest() {
		List<BoardComment> beforeCommentList = commentService.selectBoardCommentList(testArticle.getId());
		commentService.insertBoardComment(boardComment);
		List<BoardComment> afterCommentList = commentService.selectBoardCommentList(testArticle.getId());
		
		assertEquals(beforeCommentList.size()+1, afterCommentList.size());
	}
	
	@Test
	@Transactional
	public void updateBoardCommentTest() {
		commentService.insertBoardComment(boardComment);
		List<BoardComment> commentList = commentService.selectBoardCommentList(testArticle.getId());
		BoardComment testComment = commentList.get(commentList.size()-1);
		
		BoardComment testUpdateComment = new BoardComment();
		testUpdateComment.setId(testComment.getId());
		testUpdateComment.setContent("TestUpdateCommentContent");
		
		commentService.updateBoardComment(testUpdateComment);
		
		BoardComment afterUpdateComment = commentService.selectBoardCommentOne(testComment.getId());
		
		assertEquals(testUpdateComment.getContent(), afterUpdateComment.getContent());
	}
	
	@Test
	@Transactional
	public void selectBoardCommentListTest() {
		commentService.insertBoardComment(boardComment);
		List<BoardComment> commentList = commentService.selectBoardCommentList(testArticle.getId());
		BoardComment testComment = commentList.get(commentList.size()-1);
		
		assertEquals(testComment.getContent(), boardComment.getContent());
	}
	
	@Test
	@Transactional
	public void deleteBoardCommentTest() {
		commentService.insertBoardComment(boardComment);
		
		List<BoardComment> commentList = commentService.selectBoardCommentList(testArticle.getId());
		BoardComment testComment = commentList.get(commentList.size()-1);
		
		commentService.deleteBoardComment(testComment.getId());
		
		assertNull("comment is not delete!", commentService.selectBoardCommentOne(testComment.getId()));
	}
	
	@Test
	@Transactional
	public void selectBoardCommentOne() {
		commentService.insertBoardComment(boardComment);
		
		List<BoardComment> commentList = commentService.selectBoardCommentList(testArticle.getId());
		BoardComment testComment = commentList.get(commentList.size()-1);
		
		assertEquals(boardComment.getId(), commentService.selectBoardCommentOne(testComment.getId()).getId());
	}
}
