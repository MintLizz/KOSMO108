package a.b.c.com.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	Logger logger = LogManager.getLogger(HelloController.class);

	@RequestMapping(value="spring_hello")
	public String hello_spring(Model model) {
		logger.info("	HelloController.hello_spring() 함수 진입 >>> : ");
		
		model.addAttribute("msg", "Hello Spring !!!");
		logger.info("	hello_spring의 model은 ? >>> : " + model);
		
		return "spring_hello_return";
	}
	
	@RequestMapping(value="hello_hoon_get", method=RequestMethod.GET)
	public String hoon_hello_get(Model model) {
		logger.info("	HelloController의 hoon_hello_get() 함수 진입 >>> : ");
		
		model.addAttribute("msg", "Hello Hoon !!!");
		logger.info("	hoon_hello 의 model은 ? >>> : " + model);
		
		return "spring_hello_get_return";
	}
	
	@RequestMapping(value="hello_hoon_post", method=RequestMethod.POST)
	public String hoon_hello_post(Model model) {
		logger.info("	HelloController의 hoon_hello_post() 함수 진입 >>> : ");
		
		model.addAttribute("msg", "Hello Hoon !!!");
		logger.info("	hoon_hello 의 model은 ? >>> : " + model);
		
		return "spring_hello_post_return";
	}
}
