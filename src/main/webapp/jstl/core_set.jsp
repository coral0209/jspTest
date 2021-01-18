<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 1. 선언해야한다. -->
<!-- tagdir="" 속성은 개발자가 직접만든것을 가져다가 쓸때 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>set</h3>
	속성을 생성하는 태그 
	<%--request.setAttribute("속성명" , 속성값);  ==> set 태그
	${속성명} , <%= request.getAttribute("속성명"); %>
	--%>
	
	
	var : 속성명 <br>
	value : 속성값 <br>
	scope : 저장할 스코프 (page , request, session , application)<br>
		*스코프를 지정하지 않을경우 page 스코프가 적용됨 
	<%-- </c:set> --%>
	<c:set var= "userid" value="brown"/> <br>
	
	속성을 저장해 놓은 것 -> 가져다가 쓸 수 있다. <br>
	
	userid-el : ${userid}; <br>
	userid-pageContext : <%=pageContext.getAttribute("userid") %><br>
	
	property , value 속성 찾아보기 <br>
	
	<h3>remove</h3>
	스코프에 저장된 속성을 제거 : request.removeAttribute("속성명"); <br>
	<c:remove var="userid"/>
	userid-el : ${userid}; <br>
	userid-pageContext : <%=pageContext.getAttribute("userid") %><br>
</body>
</html>