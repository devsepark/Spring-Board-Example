package devsepark.board.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.common.ShaEncoder;
import devsepark.board.model.UserVo;
import devsepark.board.service.UserService;

//유저 컨트롤러
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;	//유저 서비스
	
	@Resource(name="shaEncoder")
	private ShaEncoder encoder;
	
	// 회원가입 페이지
	@RequestMapping(value = "/regist", method=RequestMethod.GET)
	public String userRegistForm(ModelMap modelMap) {
		modelMap.addAttribute("needregist", "true");
		
		logger.info("User Regist Form, URL=/regist,Method=GET");
		
		return "/index";
	}
	
	//회원가입
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String userRegist(@ModelAttribute UserVo user) {
		user.setPassword(encoder.saltEncoding(user.getPassword(), user.getId()));
		userService.insertUser(user);
		
		logger.info("User Regist : {}, URL=/regist,Method=POST", user.getId());
		
		return "/index";
	}
	
	//로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLoginForm(ModelMap modelMap) {
		modelMap.addAttribute("needlogin", "true");
		
		logger.info("Login Page : {}, URL=/login,Method=GET");
		
		return "/index";
	}
	
}
