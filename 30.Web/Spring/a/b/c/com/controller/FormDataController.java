package a.b.c.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.vo.FormDataVO;

@Controller
public class FormDataController {
	
	Logger logger = LogManager.getLogger(FormDataController.class);
	
	// index.jsp에서 요청한 값이 formdata_find 이다.
	@RequestMapping(value = "formdata_find", method = RequestMethod.GET)
	public String formdata() {
		
		// 그래서 mvc안에 있는 formdata_return 으로 가라
		// mvc/formdata_return
		// <property name="prefix" value="/WEB-INF/view/" />
		// /WEB-INF/view/mvc/formdata_return.jsp
		return "mvc/formdata_return";
		
	}
	
	
	@RequestMapping(value = "formdata_get_servlet", method = RequestMethod.GET)
	// 파일을 업로드할 때는 HttpServletRequest로 받아야 한다.
	public String formdata_get(HttpServletRequest req, Model m) {
		
		String datanum = req.getParameter("datanum");
		String dataid = req.getParameter("dataid");
		String datapw = req.getParameter("datapw");
		String dataname = req.getParameter("dataname");
		
		logger.info("	FormDataController.formdata_get()	의 datanum 은 ?	>>> : " + datanum);
		logger.info("	FormDataController.formdata_get()	의 dataid 은 ?	>>> : " + dataid);
		logger.info("	FormDataController.formdata_get()	의 datapw 은 ?	>>> : " + datapw);
		logger.info("	FormDataController.formdata_get()	의 dataname 은 ?	>>> : " + dataname);
		
		req.setAttribute("request_datanum", datanum);
		req.setAttribute("request_dataid", dataid);
		req.setAttribute("request_datapw", datapw);
		req.setAttribute("request_dataname", dataname);
		
		m.addAttribute("el_datanum", datanum);
		m.addAttribute("el_dataid", dataid);
		m.addAttribute("el_datapw", datapw);
		m.addAttribute("el_dataname", dataname);
		
		return "mvc/formdata_get_servlet";
		
	}
	
	// ***** 프로젝트 할 때는 이 방식으로 사용해야 한다.
	// Spring Web MVC 방식으로
	@RequestMapping(value = "formdata_get_spring", method = RequestMethod.GET )
	// 이거는 깡통클래스 FormDataVO에서 받았다.
	public String formdata_get_spring(FormDataVO fvo, Model m) {
		
		System.out.println("	FormDataController 의 formdata_get_spring() 함수에 진입해슴!");
		
		logger.info("	formdata_get_spring 의 fvo 는 ?	>>> : " + fvo);
		logger.info("	formdata_get_spring 의 fvo.getDatanum 은 ?	>>> : " + fvo.getDatanum());
		logger.info("	formdata_get_spring 의 fvo.getDataid 는 ?	>>> : " + fvo.getDataid());
		logger.info("	formdata_get_spring 의 fvo.getDatapw 는 ?	>>> : " + fvo.getDatapw());
		logger.info("	formdata_get_spring 의 fvo.getDataname 은 ?	>>> : " + fvo.getDataname());
		
		m.addAttribute("m_fvo", fvo);
		
		return "mvc/formdata_get_spring_return";
	}
	
	// Spring @ModelAttribute
	@RequestMapping(value = "formdata_post_spring", method = RequestMethod.POST)
	public String formdata_post_modelattribute(@ModelAttribute("ma_fdvo") FormDataVO fdvo) {
		
		System.out.println("	FormDataController 의 formdata_post_spring() 함수에 진입해슴!");
		
		
		logger.info("	formdata_post_modelattribute 의 fdvo 는 ?	>>> : " + fdvo);
		logger.info("	formdata_post_modelattribute 의 fdvo.getDatanum 은 ?	>>> : " + fdvo.getDatanum());
		logger.info("	formdata_post_modelattribute 의 fdvo.getDataid 는 ?	>>> : " + fdvo.getDataid());
		logger.info("	formdata_post_modelattribute 의 fdvo.getDatapw 는 ?	>>> : " + fdvo.getDatapw());
		logger.info("	formdata_post_modelattribute 의 fdvo.getDataname 은 ?	>>> : " + fdvo.getDataname());
		
		return "mvc/formdata_post_spring_modelattribute_return";
	}
	
	@RequestMapping(value="formdata_post_valueobject", method=RequestMethod.POST)
	public String formdata_post_valueobject(FormDataVO fdvo) {
		
		logger.info("	formdata_post_valueobject 의 fdvo 는 ?	>>> : " + fdvo);
		logger.info("	formdata_post_valueobject 의 fdvo.getDatanum()  는 ?	>>> : " + fdvo.getDatanum());
		logger.info("	formdata_post_valueobject 의 fdvo.getDataid() 는 ?	>>> : " + fdvo.getDataid());
		logger.info("	formdata_post_valueobject 의 fdvo.getDatapw() 는 ?	>>> : " + fdvo.getDatapw());
		logger.info("	formdata_post_valueobject 의 fdvo.getDataname() 는 ?	>>> : " + fdvo.getDataname());
		
		return "mvc/formdata_post_valueobject_return";
	}
	
	
}
