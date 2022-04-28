<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "org.apache.log4j.LogManager" %>
<%@ page import = "org.apache.log4j.Logger" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>SILHANg</h3>
		<hr>
		<% request.setCharacterEncoding("UTF-8"); %>
		<%
			Logger logger = LogManager.getLogger(this.getClass());
			logger.info("	boardSelect.jsp에 접속해슴!	>>> : ");
		
			Object obj = request.getAttribute("aList_select");
			if (obj == null) return;
			
			boolean bool = ((Boolean)obj).booleanValue();
			
			if (bool){
				%>
						<script>
							location.href="/kosServlet/board?isudType=SALL";
						</script>
				<%		
					}
					
				%>	
	</body>
</html>