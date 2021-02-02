<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${cp}/fileupload" method="post" enctype="multipart/form-data">
		userid : <input type="text" name="userid" value="brown"/><br> 
		<!-- input type file 태그에 임의의 파일을 value 로 쓰는것 불가능 -> 사용자의 동작에의해서만. 브라우저에서 막아놓음  -->
		파일첨부 : <input type="file" name="profile"/>
		<input type="submit" value="전송">
	</form>
</body>
</html>