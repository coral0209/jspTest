<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ %> : 지시자  - jsp 페이지에 대한 설정정보  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<% Date date = new Date();  %> <!-- 스크립틀릿 : 자바코드를 작성  -->
	Hello , World<%=date %> <%-- 표현식  : 문자열을 출력하는 역할 --%>
	
</body>
</html>


<%--
	jsp 구성요소 
	1. 지시자 : page 의 설정 정보  
	2. 스크립틀릿 : JAVA 코드 == > 나중에 JSTL(Java Standard Tag Library)  로 변경할 예정이다. 
	3. 표현식 : 문자열로 출력 ==> EL(Expression Language , 표현언어 ) 
	4. 주석 
	5. 선언부 : 변수나 method 선언 , jsp 는 화면, 컨텐츠를 생성하는 역할
				변수나 method 는 로직 처리시 주로 사용 


 --%>