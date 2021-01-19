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
   

    <title>Signin Template for Bootstrap **</title>

    <!-- common_lib.jsp 내용 밑에 붙여넣기 -->
	<%@ include file="/common/common_lib.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="${cp}/css/signin.css" rel="stylesheet">

    

	<script>
	
	// html 문서 로딩이 완료 되고 나서 실행 되는 코드 
	$(function(){
	 	//signin 아이디를 select 
		//userid, rememberme 쿠키를 확인하여 존재할 경우 값설정, 체크 
	 	if(Cookies.get("rememberme") != null && Cookies.get("userid") != null ){
	 		$("#rememberme").attr("checked" , "checked");
	 		$("#userid2").val(Cookies.get("userid")); 
	 	}
		
		
	 	$("#signin").on("click" , function(){
	 		//rememberme 체크박스가 체크 되어 있는지 확인
	 		//체크되어 있을 경우
	 		//userid input 에 있는 값을 userid 쿠키로 저장 
	 		//rememberme 쿠키로 y 값을 저장 
	 		
	 		//체크 해제되어 있는 경우 더이상 사용하지 않는다는 의미이므로 userid, rememberme 쿠키 삭제 
	 		
	 		//form 태그를 이용하여 signin 요청 
	 		if ($("#rememberme").is(":checked") == true ) {
	 			Cookies.set("userid" , $('#userid2').val());
	 			Cookies.set("rememberme" , "Y"); 
	 			
	 		}
	 		else {
	 			Cookies.remove("userid"); 
	 			Cookies.remove("rememberme"); 
	 		}
	 		
	 		
	 		//form 태그를 이용해서 sign in 요청 
	 		
	 		$('#frm').submit(); 
	 		
	 		
	 	});
	});
	
	
	
	
 	function getCookieValue(cookieStr, cookieName){
		console.log("getCookieValue"); 
		index = 0; 
		var k = [];
		var s = [];
		res = 0;
		k = cookieStr.split("; ");
		for (var i in k) {
			s = k[i].split("="); 
			if( s[0] == cookieName) {
				res = s[1]; 
				return res;
			}
		}
		
		return ""; 
		
		
	}
 	
 	
 	//cookieName : 추가하고자 하는 쿠키 이름 
 	// cookieValu : 쿠키의 값
 	// expires : 유효기간(일수)
 	
	
 	function addCookie(cookieName, cookieValue, expires){
 		var dt = new Date(); // 지금 현재 날짜 ==> expires 만큼 미래날짜로 변경 
 		dt.setDate(dt.getDate() + parseInt(expires));
 		console.log(dt); 
 		document.cookie = cookieName + "=" + cookieValue + "; " + 
 							"path=/; expires=" + dt.toGMTString(); 
 	}
 	
 	
	function deleteCookie(cookieName){
		addCookie(cookieName, "", -1 ); 
	}
 	
/* 	var cookieValue = getCookieValue(document.cookie , "userid" ); 
 	console.log(cookieValue); */
 	
 	

 	
 	
	</script>
  </head>
  <body>

    <div class="container">
	UNT_CD : ${param.UNT_CD} / <%=request.getParameter("UNT_CD") %>
	cp : ${cp } / <%=request.getAttribute("cp") %>
<!-- 개인정보를 전송하므로 URL 에 노출되지 않도록 request body 영역에 파라미터를 전송 ==> method="post" -->

      <form class="form-signin" id="frm" action="${cp}/LoginController" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
		<!-- user id : <input type="text" name="userid" value="sally"><br> -->
        <label for="userId" class="sr-only">Id</label>
        <!-- screen reader 가 시각장애인들을 위해서 인식해서 읽어줘야함.  -->
        <input type="text" id="userid2" value="brown" class="form-control" placeholder="id" name="userid" val="테스트"  required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" value="brownPass" name="pass" class="form-control" placeholder="Password"  required>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="rememberme" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="signin" >Sign in</button>
      </form>

    </div> <!-- /container -->

<!-- 에러 부분만들기 -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

  </body>
</html>
