<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<title>페이징 처리된 정보 가져오기</title>


<script src="/js/jquery/jquery-1.12.4.js"></script>
<link href="${cp}/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="${cp}/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="${cp}/css/dashboard.css"
	rel="stylesheet">
<link href="${cp}/css/blog.css" rel="stylesheet">
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
					<c:forEach items="${list}" var="user">
					<tr>
					<fmt:formatDate var="regdt" value="${user.reg_dt}" pattern="yyyy.MM.dd"/>
						<td>${user.userid}</td>
						<td>${user.usernm}</td>
						<td>${user.alias}</td>
						<td>${regdt}</td>
			
					</tr>

					</c:forEach>
			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	
</body>

</html>