package devsepark.board.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/context-*.xml",
		"classpath:/config/*-servlet.xml"})
@WebAppConfiguration
public class BoardArticleControllerTests {
	@Autowired
	private WebApplicationContext webContext;

	private MockMvc mockMvc;
	
	//테스트를 위한 게시판과 글
	private static final String TEST_BOARD_NAME = "qna";
	private static final String TEST_ARTICLE_ID = "1";
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).apply(springSecurity()).build();
	}

	@Test
	public void articleListTest() throws Exception {
		this.mockMvc.perform(get("/board/"+TEST_BOARD_NAME))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("articleList"))
		.andExpect(model().attributeExists("searchVo"))
		.andExpect(model().attributeExists("boardGroup"));
	}

	@Test
	@WithMockUser
	public void articleWriteFormTest() throws Exception {
		this.mockMvc.perform(get("/board/"+TEST_BOARD_NAME+"/form"))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("boardGroup"));
	}

	@Test
	@WithMockUser
	@Transactional
	public void articleSaveTest() throws Exception {
		this.mockMvc.perform(post("/board/"+TEST_BOARD_NAME)
				.param("title", "article save title test")
				.param("content", "article save content test"))
//		.andDo(print())
		.andExpect(status().is3xxRedirection());
	}
	
	@Test
	@WithMockUser
	public void articleUpdateFormTest() throws Exception {
		this.mockMvc.perform(get("/board/"+TEST_BOARD_NAME+"/article/"+TEST_ARTICLE_ID+"/form"))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("boardArticle"))
		.andExpect(model().attributeExists("boardGroup"));
	}
	
	@Test
	@WithMockUser
	@Transactional
	public void articleUpdateSaveTest() throws Exception {
		this.mockMvc.perform(put("/board/"+TEST_BOARD_NAME+"/article/"+TEST_ARTICLE_ID)
				.param("title", "article update title test")
				.param("content", "article update content test")
				.param("id", TEST_ARTICLE_ID))
//		.andDo(print())
		.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void articleReadTest() throws Exception {
		this.mockMvc.perform(get("/board/"+TEST_BOARD_NAME+"/article/"+TEST_ARTICLE_ID))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("boardArticle"))
		.andExpect(model().attributeExists("boardGroup"))
		.andExpect(model().attributeExists("commentList"));
	}
	
	@Test
	@WithMockUser
	@Transactional
	public void articleDeleteTest() throws Exception {
		this.mockMvc.perform(delete("/board/"+TEST_BOARD_NAME+"/article/"+TEST_ARTICLE_ID))
//		.andDo(print())
		.andExpect(status().is3xxRedirection());
	}
}
