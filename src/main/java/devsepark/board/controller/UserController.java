package devsepark.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.model.User;
import devsepark.board.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 회원가입 페이지
	@RequestMapping(value = "/regist", method=RequestMethod.GET)
	public String userRegistForm() {
		
		return "/user/regist";
	}
	
	//회원가입
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String userRegist(@ModelAttribute User user) {
		
		userService.insertUser(user);
		
		return "redirect:/user/login/form";
	}
	
	//로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLoginForm() {
		
		return "/user/login";
	}
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute User user, HttpSession session) {
		if (userService.login(user, session)){
			return "redirect:/index";
		}
		
		return "redirect:/user/login/form";
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String userLogout(HttpSession session) {
		userService.logout(session);
		
		return "redirect:/index";
	}
}
