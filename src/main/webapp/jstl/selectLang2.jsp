<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_lib.jsp"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
$(function(){
	$('#select').on('change' , function(){
		$('#sl').submit(); 
	})
	$('select').val("${param.sl}");
	
	
})

/* function sm() {
	document.frm.submit();
	$("select").val("${param.sl}");
	
} */

	
	
</script>
<body>
그냥 ${sl} 하면 속성 . 
param : [${param.sl}]
<form id="sl"name="frm" action="${pageContext.request.contextPath} /jstl/selectLang2.jsp">
<select  name="sl"  onchange="sm()" id="select">
	<option value="ko" >한국어</option>
	<option value="en" >ENGLISH</option>
	<option value="ja"  >日本語</option>
	<option value="etc" >기타</option>
</select>

<%-- select box 로 설정한 언어로 GREETING , LANG 값을 표현 
	select box 는 사용자가 설정한 언어값으로 선택이 되어 있게 설정--%>

<h3>${param.val}</h3>
<fmt:setLocale value="${param.sl}" />
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING">
		<fmt:param value="brown"/>
	</fmt:message><br>

</fmt:bundle>
</form>

</body>
</html>