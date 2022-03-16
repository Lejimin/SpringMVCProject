<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOP 상세정보</title>
</head>
<body>
	<h1>SHOP 상세</h1>
	<p>이름 : ${data.name}</p>
	<p>카테고리 : ${data.category}</p>
	<!-- 20000 을 20,000형식으로 보여줌 -->
	<p>가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}"/></p>
	<p>입력일 : <fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd.HH:mm:ss"/></p>
	
	<p><a href="/update?shopId=${shopId}">수정</a>
	<form method="POST" action="/delete">
		<input type="hidden" name="shopId" value="${shopId}"/>	
		<input type="submit" value="삭제"/>
	</form>
	<p><a href="/list">목록으로</a></p>
</body>
</html>