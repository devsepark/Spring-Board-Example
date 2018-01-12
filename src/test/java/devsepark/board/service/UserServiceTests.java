package devsepark.board.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import devsepark.board.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/context-*.xml",
		"classpath:/config/*-servlet.xml"})
@WebAppConfiguration
public class UserServiceTests {
	
	@Autowired
	private UserService userService;
	
	private UserVo user;
	
	@Before
	@Transactional
	public void setUp() {
		user = new UserVo();
		user.setId("TestUser");
		user.setName("TestUser");
		user.setPassword("935cb0d9c7d6013604827029fc61d31d1ab587cb9706bdd0a2951b87ee8bf59c");
	}
	
	@Test
	@Transactional
	public void insertUser() {
		userService.insertUser(user);
		
	}
}
