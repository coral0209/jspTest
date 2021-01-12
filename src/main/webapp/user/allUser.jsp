<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>동적으로 사용자들의 모든 정보 가져오기</title>


<script src="/js/jquery/jquery-1.12.4.js"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
</head>

<body>

	
<%--헤더부분 --%>
	<%@ include file="/common/header.jsp"%>
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
				<%--left 부분 --%>
		<%@ include file="/common/left.jsp"%>
	</ul>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
			<%=request.getAttribute("pagnation") %>
			<%List<UserVo> list = (List<UserVo>) request.getAttribute("list");
			 request.getAttribute("pagnation"); 		 
		
					for (int i = 0; i < list.size(); i++) {
					//향상된 for 문도 가능 
					request.getAttribute("pagnation"); 	
					%>
					
					<tr>
						<td><%=list.get(i).getUserid()%></td>
						<td><%=list.get(i).getUsernm()%></td>
						<td><%=list.get(i).getAllias()%></td>
						<td><%=list.get(i).getReg_dt_fmt() %></td>
			
					</tr>

					<%
					}
					%>
			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="<%=request.getContextPath()%>/pagingUser?page=1&pagesize=5">1</a></li>
				<li><a href="<%=request.getContextPath()%>/pagingUser?page=2&pagesize=5">2</a></li>
				<li><a href="<%=request.getContextPath()%>/pagingUser?page=3&pagesize=5">3</a></li>
				<li><a href="<%=request.getContextPath()%>/pagingUser?page=4&pagesize=5">4</a></li>
				<li><a href="<%=request.getContextPath()%>/pagingUser?page=5&pagesize=5">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	
</body>

</html>