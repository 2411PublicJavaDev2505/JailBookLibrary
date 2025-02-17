<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기 및 삭제</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
</head>
<body>
	<div>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<main>
		<!--<form action="" method="post">  -->
			<form action="/book/detail" method="post">
			<input type="hidden" name="bookNo" value="${book.bookNo }">
			<h2>수정하기</h2>
			
			<div>
				<label>제목 :</label>
				<input type="text" name="bookName" value="${book.bookName}">
			</div>
			<div>
				<label>글쓴이 :</label>
				<input type="text" name="bookWrite"value="${book.bookWrite }">
			</div>
			<div>
				<label>가격 :</label>
				<input type="number" name="bookPrice"value="${book.bookPrice }">
			</div>
			<div>
				<label>출판사:</label>
				<input type="text" name="publisher"value="${book.publisher }">
			</div>
			<div>
				<label>장르:</label>
				<input type="text" name="genre"value="${book.genre }">
			</div>
			<div class="">
					<div class="">
					<!-- <a href="/book/detail?bookNo=${book.bookNo }" class="">수정</a> -->
					
					<!-- <a href="/book/delete?bookNo=${book.bookNo }" class="">삭제</a> -->
					<button type="submit">수정하기</button>
					
					<a href="/book/delete?bookNo=${book.bookNo }">삭제</a>
			</div>
		</form>
	</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>