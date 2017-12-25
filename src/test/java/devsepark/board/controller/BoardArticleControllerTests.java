package devsepark.board.controller;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import devsepark.board.model.BoardArticle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/config/context-*.xml",
		"classpath:/config/*-servlet.xml"})
@WebAppConfiguration
public class BoardArticleControllerTests {
	@Autowired
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).apply(springSecurity()).build();
	}
	
	@Test
	public void articleListTest() throws Exception {
		this.mockMvc.perform(get("/board/qna"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("articleList"))
		.andExpect(model().attributeExists("searchVo"))
		.andExpect(model().attributeExists("boardGroup"));
	}
	
	@Test
	@WithMockUser(username="testUser", roles= {"USER"})
	public void articleWriteFormTest() throws Exception {
		this.mockMvc.perform(get("/board/qna/form"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("boardGroup"));
	}
	
	@Test
	public void articleSaveTest() throws Exception {
		 User user = new User("user1","ad5050928515d4ddfa2373573ee870cdd7629a8c2b9121e3f357f455fdb8e1e0", AuthorityUtils.createAuthorityList("ROLE_USER"));
	     TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(user,null);
	     SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);
	 
		this.mockMvc.perform(post("/board/qna")
		.principal(testingAuthenticationToken)
		.param("title", "article save title test")
		.param("content", "article save content test"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("boardGroup"));
	}
}
