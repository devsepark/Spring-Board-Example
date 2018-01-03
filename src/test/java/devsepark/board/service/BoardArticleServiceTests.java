package devsepark.board.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/context-*.xml",
		"classpath:/config/*-servlet.xml"})
@WebAppConfiguration
public class BoardArticleServiceTests {
	@Autowired
	private WebApplicationContext webContext;

	@Autowired
	private BoardArticleService articleService;
	
	@Test
	@WithMockUser
	@Transactional
	private void selectBoardListTest() {
		
	}
	
}
