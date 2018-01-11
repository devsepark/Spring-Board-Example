package devsepark.board.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
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
	
	@Before
	public void setUp() {
		article = new BoardArticle();
		article.setWriter("TestUser");
		article.setTitle("TestTitle");
		article.setContent("TestContent");
		article.setGroupId("1");
	}
	
	@Test
	@WithMockUser
	@Transactional
	public void selectBoardListTest() {
		
		SearchVo searchVo = new SearchVo();
		searchVo.pageCalculate(10);
		searchVo.setGroupId("1");
		
		for(int i=0; i<10; i++) {
			articleService.insertArticle(article);
		}
		
		List<BoardArticle> articleList = articleService.selectArticleList(searchVo);
		assertNotNull("failure, service is null!", articleService);
		assertNotNull("article list is null!", articleList);
		assertEquals(10, articleList.size());
		assertEquals("TestTitle", articleList.get(0).getTitle());
	}
	
	
}
