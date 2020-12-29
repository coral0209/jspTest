<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>

		<!-- 출력하는 것이 아니라 java 코드를 사용하려고 할때 스크립틀릿 사용한다.  -->
		<%
		for (int i = 1; i <= 9; i++) {
		%>

		<tr>

			<%
			for (int k = 2; k <=9; k++) {
			%>
			<!-- 표현식사용해서 출력 -->
			<td><%=k%> *  <%=i %>  = <%= k * i %></td>
			<%
			}
			%>

		</tr>

		<%
		}
		%>


	</table>

</body>
</html>