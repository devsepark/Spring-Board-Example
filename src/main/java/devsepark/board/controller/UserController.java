package devsepark.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.common.ShaEncoder;
import devsepark.board.model.UserVo;
import devsepark.board.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Resource(name="shaEncoder")
	private ShaEncoder encoder;
	
	// 회원가입 페이지
	@RequestMapping(value = "/regist", method=RequestMethod.GET)
	public String userRegistForm(ModelMap modelMap) {
		modelMap.addAttribute("regist", "true");
		return "/index";
	}
	
	//회원가입
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String userRegist(@ModelAttribute UserVo user) {
		user.setPassword(encoder.saltEncoding(user.getPassword(), user.getId()));
		userService.insertUser(user);
		
		return "/index";
	}
	
	//로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLoginForm(ModelMap modelMap) {
		modelMap.addAttribute("needlogin", "true");
		return "/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin() {
		return "/index";
	}
	
	//로그인 상태
	@RequestMapping(value = "/login/{state}", method = RequestMethod.POST)
	public String userLogin(@PathVariable("state") String state, ModelMap modelMap) {
		if(state.equals("fail")) {
			modelMap.addAttribute("fail", "true");
		}else if(state.equals("success")) {
			modelMap.addAttribute("success", "true");
		}
		
		return "redirect:/index";
	}
}
