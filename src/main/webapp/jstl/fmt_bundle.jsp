<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING">
		<fmt:param value="brown"/>
	</fmt:message><br>

</fmt:bundle> --%>

<%-- 로케일 설정 변경 --%>

<h3>japan</h3>
<fmt:setLocale value="ja" />
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING">
		<fmt:param value="brown"/>
	</fmt:message><br>

</fmt:bundle>

<h3>ENGLISH</h3>
<fmt:setLocale value="en" />
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING">
		<fmt:param value="brown"/>
	</fmt:message><br>

</fmt:bundle>

<h3>korea</h3>
<fmt:setLocale value="ko" />
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING">
		<fmt:param value="brown"/>
	</fmt:message><br>

</fmt:bundle>



<h3>setBundle : 번들값을 속성에 저장</h3>
	message태그를 사용할 때 번들을 지정 => bundle 태그 없이 사용 가능 
	
	scope속성 : 어디에 넣을지 정하는것 pageContext 가 기본 . 
<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/><br>
<fmt:message key="LANG" bundle="${msg}"/> <br>
<fmt:message key="GREETING" bundle="${msg}"> <br>
<fmt:param value="brown"/> <br>
</fmt:message><br>

</body>
</html>