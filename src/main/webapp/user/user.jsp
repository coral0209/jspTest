<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
<link href="${cp}/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="${cp}/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="${cp}/css/dashboard.css"
	rel="stylesheet">
<link href="${cp}/css/blog.css" rel="stylesheet">
<script>
//문서 로딩이 완료 됬을 떄 
$(function(){

	$('#modifyBtn').on('click' , function(){
		$("#frm").attr("method" , "get"); 
		$("#frm").attr("action" , "${cp}/userModify" );
		$("#frm").submit();
	})
	$('#deleteBtn').on('click' , function(){
		$("#frm").attr("method" , "post"); 
		$("#frm").attr("action" , "${cp}/deleteUser" );
					$("#frm").submit();
				})
	})
</script>
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
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


			<form class="form-horizontal" id="frm" role="form"
				action="${cp}/userModify">
				<input type="hidden" name="userid" value="${user.userid}">
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
					<div class="col-sm-10">
					<img src="${cp}/profile/${user.userid}.png"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">id</label>
					<div class="col-sm-10">
						<label class="control-label">${user.userid}</label>
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">name</label>
					<div class="col-sm-10">
						${user.usernm}

					</div>
				</div>
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">alias</label>
					<div class="col-sm-10">
						${user.userid}
					</div>
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
					 
				<%-- 	 <c:forEach items="${user.pass}" var="str"  >
					 *
					 </c:forEach>
						 --%>

					</div>
				</div>



				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">addr1</label>
					<div class="col-sm-10">
						${user.addr1}
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">addr2</label>
					<div class="col-sm-10">
						${user.addr2}
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">zipcode</label>
					<div class="col-sm-10">
						${user.zipcode}
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">filename</label>
					<div class="col-sm-10">
						${user.filename}
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">realfilename</label>
					<div class="col-sm-10">
						${user.realfilename}
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">

						<!-- 사용자 수정 일때 method: get(화면만 띄어줄것임) , action="${cp}/userModify" 
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