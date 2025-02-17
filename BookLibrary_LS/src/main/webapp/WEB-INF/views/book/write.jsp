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
		<link rel="stylesheet" href="../resources/css/bookwrite.css">
</head>
<body>
	<div id="container">
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<main>
		<form class="book-from"action="/book/write" method="post">
			<h2>책 등록11</h2>
			<div class="form-group">
				<label>제목 :</label>
				<input type="text" name="bookName">
			</div>
			<div class="form-group">
				<label>글쓴이 :</label>
				<input type="text" name="bookWrite">
			</div>
			<div class="form-group">
				<label>가격 :</label>
				<input type="number" name="bookPrice">
			</div>
			<div class="form-group">
				<label>출판사:</label>
				<input type="text" name="publisher">
			</div>
			<div class="form-group">
				<label>장르 : </label>
				<input type="text" name="genre">
			</div>
			<button type="submit" class="save-btn">저장</button>
		</form>
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>