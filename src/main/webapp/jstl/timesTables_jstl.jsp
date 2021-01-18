<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
	
		<!-- 출력하는 것이 아니라 java 코드를 사용하려고 할때 스크립틀릿 사용한다.  -->
		<c:forEach begin="1" end="9" var="i">
			<tr>
			<c:forEach begin="2" end="9" var="k">
				
				<td>${k} * ${i} =</td> 
				<td> ${k *i } </td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>