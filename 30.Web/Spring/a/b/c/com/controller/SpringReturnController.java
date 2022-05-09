package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringReturnController {
	
	
	@RequestMapping("viewJsp_1_stringTest_find")
	public String returnStringTest(Model m) {
		
		System.out.println("	StringReturnController returnStringTest() 함수로 진입해슴!	>>> : ");
		
		m.addAttribute("mdata", "view에 데이터를 전달할 때는 가능하면 Model 인터페이스를 사용하자.");
		
		return "viewJsp_1_stringTest_return_file";
	}
	
	@RequestMapping("viewJsp_2_modelandview_find")
	public ModelAndView returnModelAndViewTest() {
		
		System.out.println("	StringReturnController returnModelAndViewTest() 함수로 진입해슴!	>>> : ");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("mavdata", "ModelAndView Return Data");
		mav.setViewName("viewJsp_2_modelandview_return_file");
		
		return mav;
	}
	
	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
		
		md.addAttribute("mmmm"	,	"스프링에서는 void 리턴형도 "
							  	+	"리턴이 가능함. 개신기함! "
								+	"단 조건이 있음 "
							  	+	"요청 url의 이름과 "
								+	"view 의 이름이 동일해야 함!");
	}
}
