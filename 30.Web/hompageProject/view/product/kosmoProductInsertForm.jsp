<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>kosmo Product Insert Form 해슴!</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		
		$(document).ready(function(){
			
			alert("	jQuery 함수 시작해슴!");
			
			$(document).on("click", "#insertbtn", function(){
				
				alert("	입력 버튼 클릭해슴!	>>> : ");
				
				$("#insertForm").attr({
					
					'action':'kosmoProductInsert.psh',
					'method':'POST', //POST GET
					'enctype':'multipart/form-data' //multipart/form-data - application/x-www-form-urlencoded
					
				}).submit();
			});
		});
	</script>
	
</head>
<body>
	<h3>kosmo Product Insert Form 해슴!</h3>
	<hr>
		<form name = "insertForm" id = "insertForm">
			<table border = "1" class = "insertTable" align  = "center">
				<tr>
					<td align="center">
						상품 아이디 <br>
					</td>
					<td>
						<input type = "text" name = "kpid" id = "kpid">
					</td>
				</tr>
				<tr>
					<td align="center">
						상품명 <br>
					</td>
					<td>
						<input type = "text" name = "kpname" id = "kpname">
					</td>
				</tr>
				<tr>
					<td align="center">
						상품 수량 <br>
					</td>						
					<td>
						<input type = "text" name = "kpcnt" id = "kpcnt">
					</td>
				</tr>
				<tr>
					<td align="center">							
						상품 설명 <br>
					</td>
					<td>
						<textarea id = "kpdesc" name = "kpdesc" cols="50" rows="10" ></textarea>
					</td>
				</tr>
				<tr>
					<td align="center">
						상품 가격 <br>
					</td>
					<td>
						<input type = "text" name = "kpprice" id = "kpprice">
					</td>
				</tr>
				<tr>
					<td align="center">
						상품 제조사 <br>
					</td>
					<td>
						<input type = "text" name = "kpcompany" id = "kpcompany">
					</td>
				</tr>
				<tr>
					<td align="center">
						이미지 파일 <br>
					</td>
					<td>
						<input type="file" name="kpimage" id="kpimage">
					</td>
				</tr>
				<tr>
					<td>
						<input type = "button" id = "insertbtn" name = "insertbtn" value = "입력">
					</td>
				</tr>		
			</table>
		</form>
</body>
</html>