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
		
			$(document).ready(function(){
				
				// 글 쓰기 on 이벤트  매개변수 3개
				alert("	jQuery 함수 시작해슴!	>>> : ");
				console.log("	jQuery 함수 시작해슴!");
				
				$(document).on('click', "#insertBtn", function(){
					
					alert("	insertBtn 을 눌러슴!!	>>> : " + insertBtn);
					console.log("	insertBtn 을 눌러슴!!	>>> : " + insertBtn);
					
					location.href="/kosServlet/kosmo/board/board.html";
					
				}); // end of insertBtn
				
				
				// 글 목록 on 이벤트 매개변수 3개 
				
				$(document).on('click', "#selectAllBtn", function(){
					
					alert("	selectAllBtn 을 눌러슴!	>>> : " + selectAllBtn);
					console.log("	selectAllBtn 을 눌러슴!	>>> : " + selectAllBtn);
					
					 location.href="/kosServlet/board?isudType=SALL";
				
				});
				
				// 수정하기
				$(ducument).on('click', '#updateBtn', function(){
					
					alert("	updateBtn 을 눌러슴!	>>> : " + updateBtn);
					console.log("	updateBtn 을 눌러슴!	>>> : " + updateBtn);
					
					$("#boardSelectForm").attr({
						
						"action":"/kosServlet/board",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
						
					}).submit();
					
				}); // end of updateBtn
			});
		
		</script>
	</head>
	<body>
		<h3>SILHANg</h3>
		<hr>
		<!--  한글 깨지는거 방지 -->
		<% request.setCharacterEncoding("UTF-8"); %>
		<%
			Logger logger = LogManager.getLogger(this.getClass());
			logger.info("	boardSelect.jsp에 접속해슴!	>>> : ");
		
			Object obj = request.getAttribute("aList_select");
			if (obj == null) return;
			
			ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
			
			if(aList != null && aList.size() > 0) {
				
				// 여기서 BoardVO _bvo = aList.get(0) 이거를 작성한 이유
				//
				BoardVO _bvo = aList.get(0);
		%>	
		
			<%= _bvo.getBnum() %>
			<%= _bvo.getBsubject() %>
			<%= _bvo.getBwriter() %>
			<%= _bvo.getBmemo() %>
			<%= _bvo.getDeleteyn() %>
			<%= _bvo.getInsertdate() %>
			<%= _bvo.getUpdatedate() %>
		
		<form name = "boardselectForm" id = "boardselectForm" >
			<table>
			<!--  
				table을 선언해야 tr td를 사용할 수 있다. 
				form 태그의 name에 attr 요소 정보가 들어가있다.
			-->
				
				<tr>
					<td>글 번호</td>
					<td>
					
					<!--	readonly는 서버로 보낼 수 있지만,	disable은 서버를 보낼 수 없다.
						 			는 키인을 할 수 있지만,			       는 키인을 할 수 없다. 
					-->
					
						<input type = "text" class = "bnum" id = "bnum" name = "bnum" style = "width:225px;"
							  	placeholder = "글 번호" value = "<%= _bvo.getBnum() %>" readonly/>
					</td>
				</tr>
				<tr>
					<td>글 제목</td>
					<td>
						<input type = "text" class = "bsubject" id = "bsubject" name = "bsubject" style = "width:225px;"
								placeholder = "글 제목" value = "<%= _bvo.getBsubject() %>" />
					</td>
				</tr>
				<tr>
					<td>글 작성자</td>
					<td>
						<input type = "text" class = "bwriter" id = "bwriter" name = "bwriter" style = "width:225px; background-color:#e6e6e6;"
								placeholder = "글 작성자" value = "<%= _bvo.getBwriter() %>" disubled/>
					</td>
				</tr>
				<tr>
					<td>글 비밀번호</td>
					<td>
						<input type = "text" class = "bpw" id = "bpw" name = "bpw" style = "width:225px;" 
								placeholder = "글 비밀번호" maxlength="8" />
						<input type = "button" name = "bpwChk" id = "bpwChk" value = " 비밀번호 확인">
					</td>
				</tr>
				<tr>
					<td>삭제 여부</td>
					<td>
						<input type = "text" class = "deleteyn" id = "deleteyn" name = "deleteyn" style = "width:225px;" value = 'Y' desubled />
					</td>
				</tr>
				<tr>
					<td>글 내용</td>
					<td>
						<textarea class = "bmemo" id = "bmemo" name = "bmemo" cols = "30" rows = "10" ><%= _bvo.getBmemo() %></textarea>
					</td>
				</tr>
				<tr>
					<td>등록 일자</td>
					<td>
						<input type = "text" class = "insertdate" id = "insertdate" name = "insertdate" style = "width:225px;" value = "<%= _bvo.getInsertdate() %>" desubled/>
					</td>
				</tr>
				<tr>
					<td>수정 일자</td>
					<td>
						<input type = "text" class = "updatedate" id = "updatedate" name = "updatedate" style = "width:225px;" value = "<%= _bvo.getUpdatedate() %>" desubled/>
					</td>
				</tr>
				
				<tr>
					<td>작성</td>
					<td colspan = "3">	
						<!--  hidden : 히든 플래그  -->
						<input type="hidden" name="isudType" id="isudType" value="I" />
						<input type = "button" id = "insertBtn" name = "insertBtn" value = "글쓰기"/>
						<input type = "button" id = "selectAllBtn" name = "selectAllBtn" value = "목록"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type = "button" id = "updateBtn" name = "updateBtn" value = "수정"/>
					</td>
				</tr>
			</table>
		</form>
		<% 
			}
			// if!((aList != null && aList.size() > 0)) return ;
			// 이거는 0이다.
		%>
	</body>
</html>


















