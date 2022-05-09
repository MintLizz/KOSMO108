<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %> 
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>formdata get servlet jsp 해슴!</title>
	</head>
	<body>
	
		<!-- 
		<h3>formdata_get_servlet.jsp 페이지 입니당</h3>
		el_datanum >>>>   ${el_datanum }
		<hr>
		el_dataid >>> ${el_dataid }
		<hr>
		el_datapw >>>  ${el_datapw }
		<hr>
		el_dataname >>> ${el_dataname }
		-->
		
		
		<%
			Logger logger = LogManager.getLogger(this.getClass());
		  	logger.info("formdata_get_servlet.jsp 페이지 입니당 >>> : ");
		%>
		
		<%
			/*
		   Logger logger = LogManager.getLogger(this.getClass());
		   logger.info("formdata_get_servlet.jsp 페이지 입니당 >>> : ");
		   
		   
		   Object obj_datanum=request.getAttribute("request_datanum");
		   String datanum=(String)obj_datanum;
		   logger.info("datanum >>> : "+datanum);
		   
		   Object obj_dataid=request.getAttribute("request_dataid");
		   String dataid=(String)obj_dataid;
		   logger.info("dataid >>> : "+dataid);
		   
		   Object obj_datapw=request.getAttribute("request_datapw");
		   String datapw=(String)obj_datapw;
		   logger.info("datapw >>> : "+datapw);
		   
		   Object obj_dataname=request.getAttribute("request_dataname");
		   String dataname=(String)obj_dataname;
		   logger.info("dataname >>> : "+dataname);
		   */
		%>
		
		<%
			
			String datanum = request.getParameter("datanum");
			String dataid = request.getParameter("dataid");
			String datapw = request.getParameter("datapw");
			String dataname = request.getParameter("dataname");
			
			logger.info("	formdata_get_servlet.jsp 의 datanum 는 ?	>>> : " + datanum);
			logger.info("	formdata_get_servlet.jsp 의 dataid 는 ?	>>> : " + dataid);
			logger.info("	formdata_get_servlet.jsp 의 datapw 는 ?	>>> : " + datapw);
			logger.info("	formdata_get_servlet.jsp 의 dataname 는 ?	>>> : " + dataname);
			
			out.println("	formdata_get_servlet.jsp 의 datanum 는 ?	>>> : " + datanum);
			out.println("	formdata_get_servlet.jsp 의 dataid 는 ?	>>> : " + dataid);
			out.println("	formdata_get_servlet.jsp 의 datapw 는 ?	>>> : " + datapw);
			out.println("	formdata_get_servlet.jsp 의 dataname 는 ?	>>> : " + dataname);
			
		%> 
		
			<h3>스프링 콘트롤러에서 el 객체로 받아오기</h3> 
			<hr>
			${el_datanum }<br>
			${el_dataid }<br>
			${el_datapw }<br>
			${el_dataname}<br>
			<h3>스프링 콘트롤러에서 request.setAttribute() 객체로 받아오기</h3> 
			<hr>
			${request_datanum }<br>
			${request_dataid }<br>
			${request_datapw }<br>
			${request_dataname }<br>
			<hr>		
		
		formdata_get_servlet 화면이빈다!
		
	</body>
</html>