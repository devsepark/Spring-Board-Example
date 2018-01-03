package devsepark.board.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
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
public class BoardFileControllerTest {
	
	@Autowired
	private WebApplicationContext webContext;

	private MockMvc mockMvc;
	
	//테스트 파일 ID
	private static final String TEST_FILE_ID = "1";
	
	MockMultipartFile htmlMockFile = new MockMultipartFile("file", "filename.html", "text/html", "test bytes".getBytes());
//	MockMultipartFile imageMockFile = new MockMultipartFile("file", "filename.jpg", "image/jpeg", "test bytes".getBytes());
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).apply(springSecurity()).build();
	}
	
	@Test
	public void downloadImage() throws Exception{
		this.mockMvc.perform(get("/image/"+TEST_FILE_ID))
		.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser
	@Transactional
	public void uploadImage() throws Exception {
		this.mockMvc.perform(fileUpload("/image")
				.file(htmlMockFile))
//		.andDo(print())
		.andExpect(status().is(415));
	}
	
	
}
