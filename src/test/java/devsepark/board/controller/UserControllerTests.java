package devsepark.board.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserControllerTests {
	
	@Autowired
	private WebApplicationContext webContext;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).apply(springSecurity()).build();
	}
	
	@Test
	public void userRegistFormTest() throws Exception {
		this.mockMvc.perform(get("/user/regist"))
//		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	@Transactional
	public void userRegistTest() throws Exception {
		this.mockMvc.perform(post("/user/regist")
				.param("id", "testId")
				.param("name", "testName")
				.param("password", "testPass"))
//		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void userLoginFormTest() throws Exception {
		this.mockMvc.perform(get("/user/login"))
//		.andDo(print())
		.andExpect(status().isOk());
	}
	
	//실제 유저명과 패스워드를 줄 경우,인덱스로 302 리다이렉트, 아닐 경우 200 로그인 페이지로 포워딩
	@Test
	public void userLogin() throws Exception {
		this.mockMvc.perform(post("/user/login")
				.param("login_id", "testId")
				.param("login_password", "testPass"))
//		.andDo(print())
		.andExpect(status().isOk());
	}
	
	
}
