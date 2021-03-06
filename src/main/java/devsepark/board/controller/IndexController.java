package devsepark.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String indexPage() {
		
		logger.info("Index Page, URL=/index,Method=GET");
		
		return "/index";
	}
	
//	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String indextest(ModelMap modelMap) {
//		
//    	modelMap.addAttribute("boardGroup", new BoardGroup());
//		return "{}";
//	}
}
