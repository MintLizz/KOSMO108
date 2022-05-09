<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %> 

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			
			$(document).ready(function(){
				
				alert("	ready 함수 진입 해슴!	>>> : ");
				
				// GET 방식
				// http://localhost:8088/testSpring/formdata_get_servlet.psh?datanum=%EB%B0%95%EC%84%B1%ED%9B%88&dataid=123&datapw=123&dataname=123
				$(document).on("click", "#getbtn", function(){
					
					$("#formData").attr({
						
						"action":"formdata_get_servlet.psh",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();					
				});
				
				// 스프링 GET 방식
				// http://localhost:8088/testSpring/formdata_get_spring.psh?datanum=%EB%B0%95%EC%84%B1%ED%9B%88&dataid=123&datapw=123&dataname=123
				$(document).on("click", "#get_spring_btn", function(){
					alert("get_spring_btn >>> : 진입 ");
					
					$("#formData").attr({
						"action":"formdata_get_spring.psh",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();				
				});
				
				// POST 방식
				// http://localhost:8088/testSpring/formdata_post_spring.psh
				$(document).on("click", "#post_spring_btn", function(){
					alert("post_spring_btn >>> : 진입 ");
					
					$("#formData").attr({
						"action":"formdata_post_spring.psh",
						"method":"POST",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();					
				});
				
				// POST 방식
				// http://localhost:8088/testSpring/formdata_post_valueobject.psh
				$(document).on("click", "#post_spring_btn_111", function(){
					alert("post_spring_btn_111 >>> : 진입 ");
					
					$("#formData").attr({
						"action":"formdata_post_valueobject.psh",
						"method":"POST",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();			
				});
				
				/*
				 1번부터 4번까지의 비교
				 
				// GET 방식
				// http://localhost:8088/testSpring/formdata_get_servlet.psh?datanum=%EB%B0%95%EC%84%B1%ED%9B%88&dataid=123&datapw=123&dataname=123
				
				// 스프링 GET 방식
				// http://localhost:8088/testSpring/formdata_get_spring.psh?datanum=%EB%B0%95%EC%84%B1%ED%9B%88&dataid=123&datapw=123&dataname=123
				
				// POST 방식
				// http://localhost:8088/testSpring/formdata_post_spring.psh		
					
				// POST 방식
				// http://localhost:8088/testSpring/formdata_post_valueobject.psh
				*/
				
			});
		</script>
	</head>
	<body>
		<h3>formdata_return 해슴!</h3>
		<hr>
		
		<%
			Logger logger = LogManager.getLogger(this.getClass());
			logger.info("	formdata_return.jsp 해슴!	>>> : ");
		%>
		
		<h3 align = "center"> FORM DATA</h3>
			<form name = "formData" id = "formData">
				<table border = "1" align = "center">
					<tr>
						<td>회원번호 : </td>
						<td><input type = "text" name = "datanum" id = "datanum"></td>
					</tr>
					
					<tr>
						<td>아이디 : </td>
						<td><input type = "text" name = "dataid" id = "dataid"></td>
					</tr>
					
					<tr>
						<td>비밀번호 : </td>
						<td><input type = "text" name = "datapw" id = "datapw"></td>
					</tr>
					
					<tr>
						<td>이름 : </td>
						<td><input type = "text" name = "dataname" id = "dataname"></td>
					</tr>
					<tr>
						<td colspan = "2">
							<button type = "button" id = "getbtn">GET버튼</button>
							<button type = "button" id = "get_spring_btn">GET Spring</button>
							<button type = "button" id = "post_spring_btn">POST Spring</button>
							<button type = "button" id = "post_spring_btn_111">POST SPRING 111</button>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>