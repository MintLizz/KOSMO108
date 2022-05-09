<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "a.b.c.com.vo.FormDataVO" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>formdata post valueobject return jsp 해슴!</title>
	</head>
	<body>
		<h3>formdata post valueobject return jsp 해슴!</h3>
		<hr>
		
			ma_fdvo = ${ma_fdvo }
			
		<%
			/*
			Logger logger = LogManager.getLogger(this.getClass());
			logger.info("	formdata_post_valueobject_return.jsp 해슴!	>>> : ");
			
			FormDataVO fvo = new FormDataVO();
			fvo = (FormDataVO)request.getAttribute("ma_fdvo");
			
			logger.info("	fvo 는 ?	>>> : " + fvo + "<br>");
			out.println("	fvo 는 ?	>>> : " + fvo + "<br>");
			
			logger.info("	회원번호는 ?	>>> : " + fvo.getDatanum() + "<br>");
			logger.info("	아이디는 ?	>>> : " + fvo.getDataid() + "<br>");
			logger.info("	비밀번호는 ?	>>> : " + fvo.getDatapw() + "<br>");
			logger.info("	이름은 ?	>>> : " + fvo.getDataname() + "<br>");
			
			out.println("	회원번호는 ?	>>> : " + fvo.getDatanum() + "<br>");
			out.println("	아이디는 ?	>>> : " + fvo.getDataid() + "<br>");
			out.println("	비밀번호는 ?	>>> : " + fvo.getDatapw() + "<br>");
			out.println("	이름은 ?	>>> : " + fvo.getDataname() + "<br>");
			*/
		%>
		
		EL 표현식으로 데이터 추출하기 : <br>
		${formDataVO.datanum } <br>
		${formDataVO.dataid } <br>
		${formDataVO.datapw } <br>
		${formDataVO.dataname } <br>
		<hr>
		EL 표현식 및 객체함수로 데이터 추출하기 : <br>
		${formDataVO.getDatanum() } <br>
		${formDataVO.getDataid() } <br>
		${formDataVO.getDatapw() } <br>
		${formDataVO.getDataname() } <br>
		
		<hr>
	</body>
</html>