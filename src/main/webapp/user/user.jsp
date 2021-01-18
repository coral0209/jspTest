<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">
<script>
//문서 로딩이 완료 됬을 떄 
$(function(){

	$('#modifyBtn').on('click' , function(){
		$("#frm").attr("method" , "get"); 
		$("#frm").attr("action" , "${pageContext.request.contextPath}/userModify" );
		$("#frm").submit();
	})
	$('#deleteBtn').on('click' , function(){
		$("#frm").attr("method" , "post"); 
		$("#frm").attr("action" , "${pageContext.request.contextPath}/deleteUser" );
					$("#frm").submit();
				})
	})
</script>
</head>

<body>

	<%
	UserVo vo = (UserVo) request.getAttribute("user");
	%>


	<%--헤더부분 --%>
	<%@ include file="/common/header.jsp"%>
	<div class="row">

		<div class="col-sm-3 col-md-2 sidebar">
			<ul class="nav nav-sidebar">
				<%--left 부분 --%>
				<%@ include file="/common/left.jsp"%>
			</ul>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


			<form class="form-horizontal" id="frm" role="form"
				action="${pageContext.request.contextPath}/userModify">
				<input type="hidden" name="userid" value="<%=vo.getUserid()%>">
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
					<div class="col-sm-10">
					<img src="${pageContext.request.contextPath}/profile/<%=vo.getUserid()%>.png"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">id</label>
					<div class="col-sm-10">
						<label class="control-label"><%=vo.getUserid()%></label>
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">name</label>
					<div class="col-sm-10">
						<%=vo.getUsernm()%>

					</div>
				</div>
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">alias</label>
					<div class="col-sm-10">
						<%=vo.getAllias()%>
					</div>
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<%
						String pass = vo.getPass();
						for (int i = 0; i < pass.length(); i++) {
							out.print("*");
						%>
						<%
						}
						%>

					</div>
				</div>



				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">addr1</label>
					<div class="col-sm-10">
						<%=vo.getAddr1()%>
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">addr2</label>
					<div class="col-sm-10">
						<%=vo.getAddr2()%>
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">zipcode</label>
					<div class="col-sm-10">
						<%=vo.getZipcode()%>
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">filename</label>
					<div class="col-sm-10">
						<%=vo.getFilename()%>
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">realfilename</label>
					<div class="col-sm-10">
						<%=vo.getRealfilename()%>
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">

						<!-- 사용자 수정 일때 method: get(화면만 띄어줄것임) , action="${pageContext.request.contextPath}/userModify" 
						사용자 삭제 : method : post (db에 변화가생김) action = /deleteUser 
						파라미터는 둘다 userid 하나만 있으면 가능   -->
						<button type="button" id="modifyBtn" class="btn btn-default">사용자수정</button>
						<button type="button" id="deleteBtn" class="btn btn-default">사용자삭제</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>