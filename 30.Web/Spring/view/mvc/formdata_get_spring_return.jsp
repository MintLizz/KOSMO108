<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>  
<%@ page import = "a.b.c.com.vo.FormDataVO" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>formdata get spring return 해슴!</title>
	</head>
	<body>
		<h3>formdata get spring return 해슴!</h3>
		<hr>
		m_fvo >>> : ${m_fvo }
		<hr>
		<%
		   Logger logger=LogManager.getLogger(this.getClass()); 
		   logger.info("formdata_get_spring_return.jsp 페이지 입니당 >>> : ");
		   
		   FormDataVO fvo=new FormDataVO();
		   fvo=(FormDataVO)request.getAttribute("m_fvo");
		   logger.info("fvo >>> : "+fvo+"<br>");
		   out.println("fvo >>> : "+fvo+"<br>");
		   
		   logger.info("회원번호 >>> : "+fvo.getDatanum());
		   logger.info("아이디 >>>  : "+fvo.getDataid());
		   logger.info("비밀번호 >>> : "+fvo.getDatapw());
		   logger.info("이름 >>> : "+fvo.getDataname());
		   
		   out.println("회원번호 >>> : "+fvo.getDatanum()+"<br>");
		   out.println("아이디 >>>  : "+fvo.getDataid()+"<br>");
		   out.println("비밀번호 >>> : "+fvo.getDatapw()+"<br>");
		   out.println("이름 >>> : "+fvo.getDataname());
		%>
	</body>
</html>