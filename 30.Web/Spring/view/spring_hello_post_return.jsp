<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %> 
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Hello Seong Hoon POST!!</h3>
		<hr>
		
		<%
			Logger logger = LogManager.getLogger(this.getClass());
			logger.info("	spring_hello_post_return.jsp에 들어왔음! >>> : ");
		
			String mgsV = (String)request.getAttribute("msg");
			logger.info("	mgsV 는 ?	>>> : " + mgsV);
			out.println("	mgsV 는 ?	>>> : " + mgsV);
		%>
		
	</body>
</html>