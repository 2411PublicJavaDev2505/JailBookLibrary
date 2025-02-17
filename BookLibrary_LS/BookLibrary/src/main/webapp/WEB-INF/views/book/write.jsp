<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 등록</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
</head>
<body>
	<div>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<main>
		<form action="/book/write" method="post">
			<h2>책 등록</h2>
			<div>
				<label>제목 :</label>
				<input type="text" name="bookName">
			</div>
			<div>
				<label>글쓴이 :</label>
				<input type="text" name="bookWrite">
			</div>
			<div>
				<label>가격 :</label>
				<input type="number" name="bookPrice">
			</div>
			<div>
				<label>출판사:</label>
				<input type="text" name="publisher">
			</div>
			<div>
				<label>장르 : </label>
				<input type="text" name="genre">
			</div>
			<button type="submit">저장</button>
			
		</form>
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>