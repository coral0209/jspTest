<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	pageContext.setAttribute("price", 100000); 
%>
<c:set var="price" value="100000"/> <%--100000(숫자) ==> 100 ,000 (문자) --%>
<c:set var="priceStr" value="100,000"/> <%--100,000(문자) ==> 100000(숫자) --%>



price : ${ price }<br>
price fmt : <fmt:formatNumber value="${price}" type="number"/><br>
price fmt : <fmt:formatNumber value="${price}" type="currency"/><br>
price fmt : <fmt:formatNumber value="${price}" type="percent"/><br>
price fmt : <fmt:formatNumber value="${price}" pattern="00000000.00000"/><br>
담은값은 문자였는데, 숫자로 변환해줌 <br>
priceStr parse : <fmt:parseNumber value="${priceStr}" /><br>



<h3>de-Germany</h3>
<fmt:setLocale value="de"/>

price : ${ price }<br>
price fmt : <fmt:formatNumber value="${price}" type="number"/><br>
price fmt : <fmt:formatNumber value="${price}" type="currency"/><br>
price fmt : <fmt:formatNumber value="${price}" type="percent"/><br>
price fmt : <fmt:formatNumber value="${price}" pattern="00000000.00000"/><br>
</body>
</html>