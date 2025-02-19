<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 수정하기</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
</head>
<body>
	<div>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<main>
		<form action="" method="post">
			<input type="hidden" name="bookNo" value="${book.bookNo }">
			<h2>책 수정</h2>
			<div class="form-group">
			<lable>제목</lable>
			<input type="text" name="">
			</div>
			<button type="submit">수정하기</button>
			<a href="#">삭제하기</a>
		</form>
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>