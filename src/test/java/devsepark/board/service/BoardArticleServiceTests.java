package devsepark.board.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

import devsepark.board.common.SearchVo;
import devsepark.board.model.BoardArticle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/context-*.xml",
		"classpath:/config/*-servlet.xml"})
@WebAppConfiguration
public class BoardArticleServiceTests {

	@Autowired
	private BoardArticleService articleService;
	
	private BoardArticle article;
	private SearchVo search;
	
	@Before
	public void setUp() {
		article = new BoardArticle();
		article.setWriter("TestUser");
		article.setTitle("TestTitle");
		article.setContent("TestContent");
		article.setGroupId("1");
		
		search = new SearchVo();
		search.pageCalculate(10);
		search.setGroupIdArray(new String[] {"1"});
	}
	
	@Test
	@Transactional
	public void selectArticleListTest() {
		
		for(int i=0; i<10; i++) {
			articleService.insertArticle(article);
		}
		
		List<BoardArticle> articleList = articleService.selectArticleList(search);
		assertNotNull("failure, service is null!", articleService);
		assertNotNull("article list is null!", articleList);
		assertEquals(10, articleList.size());
		assertEquals(article.getTitle(), articleList.get(0).getTitle());
	}
	
	@Test
	@Transactional
	public void insertArticleTest() {
		long count = articleService.selectArticleCount(search);
		
		articleService.insertArticle(article);
		
		long afterInsertCount = articleService.selectArticleCount(search);
		
		BoardArticle InsertedArticle = articleService.selectRecentArticle();
		
		assertEquals(count + 1, afterInsertCount);
		assertEquals(article.getTitle(), InsertedArticle.getTitle());
	}
	
	@Test
	@Transactional
	public void updateArticleTest() {
		articleService.insertArticle(article);
		String targetId = articleService.selectRecentArticle().getId();
		
		BoardArticle updateArticle = new BoardArticle();
		updateArticle.setId(targetId);
		updateArticle.setTitle("UpdateTestTitle");
		updateArticle.setContent("UpdateTestContent");
		
		articleService.updateArticle(updateArticle);
		
		BoardArticle afterUpdateArticle = articleService.selectRecentArticle();
		
		assertEquals(updateArticle.getTitle(), afterUpdateArticle.getTitle());
	}
	
	@Test
	@Transactional
	public void selectArticleOneTest() {
		articleService.insertArticle(article);
		
		BoardArticle selectedArtice = articleService.selectArticleOne(articleService.selectRecentArticle().getId());
		
		assertEquals(article.getTitle(), selectedArtice.getTitle());
	}
	
	@Test
	@Transactional
	public void deleteArticleOne() {
		articleService.insertArticle(article);
		
		String targetId = articleService.selectRecentArticle().getId();
		
		articleService.deleteArticleOne(targetId);
		
		assertNull("article is not deleted", articleService.selectArticleOne(targetId));
	}
	
	@Test
	@Transactional
	public void updateArticleHitTest() {
		articleService.insertArticle(article);
		
		String targetId = articleService.selectRecentArticle().getId();
		
		articleService.updateArticleHit(targetId);
		
		assertEquals("1", articleService.selectArticleOne(targetId).getHit());
	}
	
	@Test
	@Transactional
	public void selectArticleCountTest() {
		long count = articleService.selectArticleCount(search);
		
		articleService.insertArticle(article);
		
		long afterInsertCount = articleService.selectArticleCount(search);
		
		assertEquals(count + 1, afterInsertCount);
	}
	
	@Test
	@Transactional
	public void selectRecentArticleTest() {
		articleService.insertArticle(article);
		
		BoardArticle recentArticle = articleService.selectRecentArticle();
		
		assertEquals(article.getTitle(), recentArticle.getTitle());
	}
}
