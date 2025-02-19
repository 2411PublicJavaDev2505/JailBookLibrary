<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>제일 BOOK 대여 관리</title>
	<link rel="stylesheet" href="../resources/css/reset.css">
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/footer.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	${lList }
	<h1>대여관리</h1>
	<a href="/library/write">대여 등록</a>
	<a href="/library/delete">대여 삭제</a>
	<table>
		<thead>
			<tr>
				<th>대여번호</th>
				<th>책제목</th>
				<th>고객ID</th>
				<th>대여일</th>
				<th>반납일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${lList }" var="library">
			<tr>
				<td class="lNum">${library.leaseNo }</td>
				<!--<td class="bNum">${library.bookNo }</td> -->
				<td class="bName">${library.bookName }</td>
				<td class="userId">${library.userId }</td>
				<td class="lDate">${library.leaseDate }</td>
				<td class="eDate">${library.returnDate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>