

<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	BasicDataSource bs = (BasicDataSource)application.getAttribute("bs"); 
	
	
	/* //시작 */
	long startTime = System.currentTimeMillis(); 
	
	/* 컨넥션을 데이터 소스로부터 얻고 반환하는 반복작업 */
	for(int i = 0 ; i < 30; i++){
		Connection connection = bs.getConnection(); 
		connection.close(); 
	
	}
	

	long endTime = System.currentTimeMillis(); 
	out.print("duration : " + (endTime - startTime)); 
	//종료 ( 작업 시간 확인) 
	
	
	
	
	
	
	
	%>
</body>
</html>