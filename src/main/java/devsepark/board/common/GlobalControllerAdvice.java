package devsepark.board.common;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import devsepark.board.model.UserDetailsVo;

//컨트롤러 공통 기능을 위한  ControllerAdvice 클래스
@ControllerAdvice(basePackages= {"devsepark.board.controller"})
public class GlobalControllerAdvice {
	//인증된 사용자명,ID
	@ModelAttribute
	public void getAuthenticationAttribute(Model model, Authentication auth) {
		if(auth!=null) {
			UserDetailsVo userDetails = (UserDetailsVo)auth.getPrincipal();
			model.addAttribute("userName", userDetails.getName());
			model.addAttribute("userId", userDetails.getId());
		}
	}
}
