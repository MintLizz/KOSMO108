<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import = "java.io.BufferedReader" %>
<%@ page import = "java.io.InputStreamReader" %>
<%@ page import = "java.net.URL" %>

<%@ page import = "a.b.c.test.xml.OracleXmlTest_1" %>
<%

	String tablename = request.getParameter("tablename");
	OracleXmlTest_1 oxt_1 = new OracleXmlTest_1();
	boolean bool = oxt_1.makeXml(tablename);
	//bool = false;
	if (!bool) return;

	String strHtml = "";
	String strLine = "";
	
	try {
		String strUrl = "http://localhost:8088/kosmoMember/kos_xml/emp.xml";
		
		//버퍼를 사용하는 이유
		// 기본 OS에서 읽고 쓰기 요청을 처리하는데 디스크 액세스, 네트워크 활동 또는 상대적으로 비용이 많이 드는
		// 기타 작업을 유발한다. 그래서 프로그램을 덜 효율적으로 만드는 경우가 발생함.
		// 이런 점을 보완하기 위해 버퍼란 것을 사용함.
		// 버퍼는 데이터를 한곳에서 다른 한곳으로 전송하는 동안 일시적으로 그 데이터를
		// 보관하는 메모리 영역임. 임시 저장소라고 함
		// I/O란 ? Input Output을 의미한다.
		// 버퍼를 사용하면 문자를 묶어서 한번에 전달할 때 전송시간이 적게 걸림. 즉 성능이 향상된다.
		BufferedReader br = new BufferedReader(
			new InputStreamReader((new URL(strUrl))
			.openConnection().getInputStream(),"UTF-8"));
		
		while ((strLine = br.readLine()) != null){
			strHtml += strLine;
		}
		
		System.out.println(strHtml);
		br.close();
	} catch(Exception e) {
		throw e;
	}
%>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>XML PARSING</title>
	
	<!-- jQuery CDN 불러오기  -------------------------------------------->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script type="text/javascript">
		
		$(document).ready(function(){
			
			var xmlText, xmlParser, xmlDoc;
			
			xmlText = "<%= strHtml %>";
			alert(xmlText);
			
			xmlParser = new DOMParser();
			xmlDoc = xmlParser.parseFromString(xmlText, "text/xml");
			alert(xmlDoc);
			
			$("#parseText").click(function(){
				
				alert("parseText 버튼 클릭해슴!!");
				
				document.getElementById("text").innerHTML = xmlDoc;
				
				var empno, ename, job, mgr, hiredate, sal, comm, deptno
				
				var nlist = xmlDoc.getElementsByTagName("EMPNO").length;
				
				for (i = 0; i < nlist; i++) {
					
				empno		= xmlDoc.getElementsByTagName("EMPNO")[i].childNodes[0].nodeValue;
				ename		= xmlDoc.getElementsByTagName("ENAME")[i].childNodes[0].nodeValue;
				job			= xmlDoc.getElementsByTagName("JOB")[i].childNodes[0].nodeValue;
				mgr			= xmlDoc.getElementsByTagName("MGR")[i].childNodes[0].nodeValue;
				hiredate	= xmlDoc.getElementsByTagName("HIREDATE")[i].childNodes[0].nodeValue;
				sal			= xmlDoc.getElementsByTagName("SAL")[i].childNodes[0].nodeValue;
				comm		= xmlDoc.getElementsByTagName("COMM")[i].childNodes[0].nodeValue;
				deptno		= xmlDoc.getElementsByTagName("DEPTNO")[i].childNodes[0].nodeValue;
					
				console.log(			empno 
						+ "," + ename
						+ "," + job
						+ "," + mgr
						+ "," + hiredate
						+ "," + sal
						+ "," + comm
						+ "," + deptno);
				
				console.log("=====================================================================");
				
				console.log("xmlDoc.getElementsByTagName(EMPNO)["+i+"].childNodes[0].nodeValue + " + empno );
				console.log("");
				console.log("xmlDoc.getElementsByTagName(ENAME)["+i+"].childNodes[0].nodeValue + " + ename );
				console.log("");
				console.log("xmlDoc.getElementsByTagName(JOB)["+i+"].childNodes[0].nodeValue + " + job );
				console.log("");
				console.log("xmlDoc.getElementsByTagName(MGR)["+i+"].childNodes[0].nodeValue + " + mgr );
				console.log("");
				console.log("xmlDoc.getElementsByTagName(HIREDATE)["+i+"].childNodes[0].nodeValue + " + hiredate );
				console.log("");
				console.log("xmlDoc.getElementsByTagName(SAL)["+i+"].childNodes[0].nodeValue + " + sal );
				console.log("");
				console.log("xmlDoc.getElementsByTagName(COMM)["+i+"].childNodes[0].nodeValue + " + comm );
				console.log("");
				console.log("xmlDoc.getElementsByTagName(DEPTNO)["+i+"].childNodes[0].nodeValue + " + deptno );
				
				console.log("=====================================================================");
				
				}
			});
			
			$("#parseFind").click(function(){
				
				alert("parseFind 버튼 클릭해슴!!");
				
				$(xmlText).each(function(){
					var empno = $(this).find("EMPNO").text();
					var ename = $(this).find("ENAME").text();
					$("#text").append(empno).append(ename);
				});	
			});
		});
	</script>
	</head>
	<body>
	<h3>XML 데이터 파싱하기</h3>
	<hr>
	<button id="parseText">DOM Parser로 XML 파싱하기 </button>
	<button id="parseFind">find() 함수로 파싱하기 </button> 
	<p id="text"></p> 
	</body>
</html>






























