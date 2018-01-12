package devsepark.board.service;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/context-*.xml",
		"classpath:/config/*-servlet.xml"})
@WebAppConfiguration
public class BoardFileServiceTests {
	
	MockMultipartFile htmlMockFile = new MockMultipartFile("file", "filename.html", "text/html", "test bytes".getBytes());
//	MockMultipartFile imageMockFile = new MockMultipartFile("file", "filename.jpg", "image/jpeg", "test bytes".getBytes());

	@Autowired
	private BoardFileService fileService;
	
	@Test
	@Transactional
	public void fileStoreTest() throws Exception {
		assertNull("file object is not null!" ,fileService.fileStore(htmlMockFile));
	}
	
	@Test
	@Transactional
	public void selectBoardFileOneTest() {
		assertNull("file object is not null!", fileService.selectBoardFileOne("some test file id"));
	}
	
	public void loadAsResource() {
		//파일 저장, 삭제 기능 구현하여 작성.
	}
	
}
