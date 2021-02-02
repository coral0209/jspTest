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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="${cp}/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="${cp}/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="${cp}/css/dashboard.css"
	rel="stylesheet">
<link href="${cp}/css/blog.css" rel="stylesheet">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
<!-- 달력 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    //load함수를 이용하여 core스크립트의 로딩이 완료된 후, 우편번호 서비스를 실행합니다.
  $(function(){
	  $( "#datepicker" ).datepicker();
	  $("#addrBtn").on("click" , function(){
	    daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	                data.roadAddress; //도로주소
	                data.zonecode; //우편주소 
	            	
	              $('#addr1').val(data.roadAddress); 
	              $('#zipcode').val(data.zonecode);
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	                // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            	//사용자 편의성을 위해 상세주소 입력 input 태그로 focus 설정 
	              $("#addr2").focus(); 
	            }
	        }).open();
	    });
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

	
			<form class="form-horizontal" role="form" action="${cp}/userModify" method="post" enctype="multipart/form-data">
				<input type="hidden" name="userid" value="${userVo.userid}"/>
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">id</label>
					<div class="col-sm-10">
						<label class="control-label">${userVo.userid}</label>
						<input type= hidden value="${userVo.userid}" name="userid">
					</div>
				</div>
				
						<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">사용자사진</label>
					<div class="col-sm-10">
						<img src="${cp}/profile/${userVo.userid}.png" >
						<img src="/profile?userid="${userVo.userid}" >
						<input type= hidden value="${userVo.realfilename}" name="realfilename">
						<input type= hidden value="${userVo.filename}" name="filename">
						<input type="file" class="form-control" id="profile" name="profile"/>
					</div>
				</div>

				

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">name</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" id="userNm" name="userNm"
								value="${userVo.usernm}" >
						
						
					</div>
				</div>
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">alias</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" id="useralias" name="userAlias"
								value="${userVo.alias}">
						
					</div>
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
					<input type="password" class="form-control" id="pass" name="pass"
					placeholder="Password" value="${userVo.pass}" >						
					</div>
				</div>
				
	<!-- 							<div class="form-group">
					<label for="reg_dt" class="col-sm-2 control-label">reg_dt</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" id="reg_dt" name="reg_dt"
					value="yyyy.mm.dd">						
					</div>
				</div> -->



				<div class="form-group">
					<label for="datepicker" class="col-sm-2 control-label">등록 날짜</label>
					<div class="col-sm-10">
					<%-- <input type="text" class="form-control" id="reg_dt" name="reg_dt" value="<%=reg_dt%>"
					placeholder="yyyy.mm.dd">	 --%>
					<input type="text" class="form-control" name="reg_dt" value="yyyy.mm.dd" id="datepicker"/>				
					</div>
				</div>
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">addr1</label>
					<div class="col-sm-8">
					<input type="text" class="form-control" id="addr1" name="addr1" readonly
					value="${userVo.addr1}">		
					</div>
					<div class="col-sm-2">
					<button type="button" id="addrBtn" class="btn btn-default">주소검색</button>				
					</div>
				</div>
				
				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">addr2</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" id="addr2" name="addr2"
					value="${userVo.addr2}">		
						
					</div>
				</div>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">zipcode</label>
					<div class="col-sm-10">
					<input type="text" class="form-control" id="zipcode" name="zipcode" readonly
					value="${userVo.zipcode}">	
					</div>
				</div>
			
				
									
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" action="${cp}/userModify" method="POST" class="btn btn-default">사용자수정</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>