<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.List" %>
<%@ page import="a.b.c.com.kosmo.product.vo.KosmoProductVO" %>
<%@ page import="a.b.c.com.kosmo.common.NumUtil" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("UTF-8");%>
<%
	// 페이징 변수 세팅!
	int pageSize = 0;
	int groupSize = 0;
	int curPage = 0;
	int totalCount = 0;
	
	Object objPaging = request.getAttribute("pagingKPVO");
	KosmoProductVO pagingKPVO = (KosmoProductVO)objPaging;
	
	Object obj = request.getAttribute("listAll");
	List<KosmoProductVO> list = (List<KosmoProductVO>)obj;
	
	int nCnt = list.size();
	System.out.println("	nCnt 는 ?	>>> : " + nCnt);
	
%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script type="text/javascript" src="/kosmoSpring/js/common.js"></script>
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				
				
				
			});
			
		</script>
		
		<style type = "text/css">
		</style>
	</head>
	<body>
		<h3>kosmoProduct SelectAll 해슴!</h3>
		<hr>
		
		<form name = "productList" id = "productList">
			<table border = "1" align = "center">
				<thead>
					<tr>
						<td>사진</td>
						<td>내용</td>
						<td>가격</td>	
					</tr>
				</thead>
				
				<%
					String kpnum = "";
					String kpprice = "";
					for (int i = 0; i < nCnt; i++) {
						
						KosmoProductVO _kpvo = list.get(i);
						kpnum = _kpvo.getKpnum();
						kpprice = _kpvo.getKpprice();
						kpprice = NumUtil.comma(kpprice);
						
						// 페이지 세팅
						pageSize = Integer.parseInt(pagingKPVO.getPageSize());
						groupSize = Integer.parseInt(pagingKPVO.getGroupSize());
						curPage = Integer.parseInt(pagingKPVO.getCurPage());
						totalCount = Integer.parseInt(_kpvo.getTotalCount());
					
				%>
				
				<tbody>
					<tr>
						<td rowspan = "5" align = "center" style = "width : 100px;">
						<img src = "/kosmoSpring/fileupload/product/<%= _kpvo.getKpimage()%>" width = "50" height = "50"><br>
						<%= _kpvo.getKpid() %>
						</td>
						<td align = "left" style = "width : 300px">상품 번호 : <%= kpnum %></td>
						<td rowspan = "5" align="center" vertical-align="middle" style="width:150px;">
						<%= kpprice %>&nbsp;&nbsp;
						<a href = "kosmoProductSelect.psh?kpnum=<%= kpnum %>">
							<img src = "/kosmoSpring/img/img_mando/ase.gif" width = "25" height = "25" alt = "image">
						</a>
					</tr>
					<tr><td>상품 설명  :<%= _kpvo.getKpdesc() %></td></tr>
					<tr><td>제조사 : <%= _kpvo.getKpcompany() %></td></tr>
					<tr><td>상품 등록일 : <%= _kpvo.getKpinsertdate() %></td></tr>
					<tr><td>등록 수정일 : <%= _kpvo.getKpupdatedate() %></td></tr>
				<%
					} // end of for
				%>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3">
							<jsp:include page="productPaging.jsp" flush="true">
								<jsp:param name="url" value="kosmoProductSelectAll.psh"/>
								<jsp:param name="str" value=""/>
								<jsp:param name="pageSize" value="<%=pageSize%>"/>
								<jsp:param name="groupSize" value="<%=groupSize%>"/>
								<jsp:param name="curPage" value="<%=curPage%>"/>
								<jsp:param name="totalCount" value="<%=totalCount%>"/>
							</jsp:include>
						</td>
					</tr>
					<tr>
						<td colspan = "3" align = "right">
							<a href = "kosmoProductInsertForm.psh">상품 추가</a>
						</td>
					</tr>							
				</tfoot>
			</table>
		</form>
	</body>
</html>















