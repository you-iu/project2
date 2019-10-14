<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section{
		width: 700px;
		margin: 0 auto;
	}
	table,td{
		border:1px solid black;
		border-collapse: collapse;
	}
	tr,th{
		border:1px solid black;
		border-collapse: collapse;
	}
	
</style>
</head>
<body>
	<p>
		<a href="add.do">[새 프로젝트 등록]</a>
	</p>
	<table>
	<tr>
		<th>프로젝트 이름</th>
		<th>시작날짜</th>
		<th>종료날짜</th>
		<th>상태</th>
	</tr>
		<c:forEach var="p" items="${list }">
			<tr>
				<td><a href="read.do?no=${p.project_no }">${p.project_name }</a></td>
				<td>${p.regdate }</td>
				<td>${p.moddate }</td>
				<td>${p.project_re }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>