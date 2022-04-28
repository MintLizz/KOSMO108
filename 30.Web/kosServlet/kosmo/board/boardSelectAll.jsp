<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "a.b.c.com.kosmo.board.vo.BoardVO" %>
<%@ page import = "org.apache.log4j.LogManager" %>
<%@ page import = "org.apache.log4j.Logger" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type = "text/javascript">
		
			/*
			//체크박스 체크 확인하기 
			function checkOnly(chk){
				// alert(">>> : " + chk);
				var chkObj = document.getElementsByName("bnumCheck");
				console.log("chkObj >>> : " + chkObj);
				for (var i=0; i < chkObj.length; i++){
					if (chkObj[i] != chk){
						chkObj[i].checked = false;
					}
				}
			}
			*/
		
			$(document).ready(function(){
			
				// 등록하기!
				
				alert("	boardSelectAll.jsp 시작해슴!	>>> : ");
				
				$("#I").on('click',function(){
					
					location.href = "/kosServlet/kosmo/board/board.html";
					
				});
				
				// 조회하기!
				$("#SALL").on('click',function(){
					
					location.href = "/kosServlet/board?isudType=SALL";
					
				});
				
				// 체크박스 선언 - 하나만 체크받을 수 있게
				$(document).on('click', '#bnumChk', function(){
					
					if ($(this).prop('checked')) {
						
						$(".bnumChk").prop('checked',false);
						$(this).prop('checked',true);
						return
					}
					// checked가 되면 true다.
				});
				
				$(document).on('click', '#U', function(){
					
					if ($(this).prop('checked')) {
						
						$(".bnumChk").prop('checked',false);
						$(this).prop('checked',true);
						return
					}
					// checked가 되면 true다.
				});
				
				// 수정하기
				$('#U').on('click',function(){
					
					if ($('.bnumChk:checked').length == 0 ) {
						
						alert("	체크박스를 1개를 선택하세요!");
						
						return;
						
					}
					
					$('#isudType').val('U');
					$('#boardSelectAll').attr({
						"action":"/kosServlet/board",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
					
				});
			});
		</script>
		
		<style type = "text/css">
			.tt {
				text-align : center;
			}
			
		</style>
	</head>
	<body>
		<h3>SILHANg</h3>
		<hr>
		
		<% request.setCharacterEncoding("UTF-8"); %>
		<form name = "boardSelectAll" id = "boardSelectAll">
			<table border = "1">
				<tr>
					<td class = "tt">
						<input type = "checkbox" class = "chkAll" id = "chkAll" name = "chkAll" />
					</td>
					<td class = "tt" style = "width:60px; background-color:cyan;">글 번호</td>
					<td class = "tt" style = "width:70px;">글 제목</td>
					<td class = "tt" style = "width:100px;">글 작성자</td>
					<td class = "tt" style = "width:150px;">글 내용</td>
					<td class = "tt" style = "width:100px;">글 등록일</td>
					<td class = "tt" style = "width:100px;">작성 날짜</td>
				</tr>
			<%
				Logger logger = LogManager.getLogger(this.getClass());
				logger.info("	boardSelectAll.jsp에 접속해슴!	>>> : ");
			
				Object obj = request.getAttribute("aList_selectALL");
				if (obj == null) return;
				
				ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
				int nCnt = aList.size();
				logger.info("	boardSelectAll.jsp 전체조회 건수는 ?	>>> : " + nCnt);
				
				// 데이터를 뽑아본다.
				for( int i = 0; i < nCnt; i++) {
					BoardVO _bvo = aList.get(i);
					
			%>
				<tr>
					<td class="tt">
						<input type="checkbox" class="bnumChk" name="bnumChk" id="bnumChk" value="<%= _bvo.getBnum() %>" />
					</td>
					<td class="tt"><%= i + 1 %></td>
					<td class="tt"><%= _bvo.getBnum() %></td>
					<td class="tt"><%= _bvo.getBsubject() %></td>
					<td class="tt"><%= _bvo.getBwriter() %></td>
					<td class="tt"><%= _bvo.getBmemo() %></td>
					<td class="tt"><%= _bvo.getInsertdate() %></td>
				</tr>	
			<%		
				}
				
			%>
				<tr>		
					<td colspan="7" align="right">
						<input type="hidden" name="isudType" id="isudType" value="" />
						<input type="button" value="등록" id="I" name = "I">
						<input type="button" value="조회" id="SALL" name = "SALL">
						<input type="button" value="수정" id="U" name = "U">
						<input type="button" value="삭제" id="D" name = "D">
					</td>
				</tr>
						
			</table>
		</form>
	</body>
</html>