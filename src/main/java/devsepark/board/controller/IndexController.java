package devsepark.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devsepark.board.model.BoardGroup;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index() {
		logger.info("index page,");
		return "/index";
	}
	
//	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String indextest(ModelMap modelMap) {
//		
//    	modelMap.addAttribute("boardGroup", new BoardGroup());
//		return "{}";
//	}
}
