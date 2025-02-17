<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제일 BOOK main</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
	</head>
<body>
		<div id="container">
			<main>
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			
			<h2>올해의 작가</h2>
			<img src="/WEB-INF/resources/image/writerimg.png" alt="writer">
			<p><b>올해의 작가</b></p>
			<p>
				한강(강 아님)
			</p>
			<h2>올해의 문학</h2>
			<img src="/WEB-INF/resources/image/bookimg1.png" alt="bookimg1">
			<p><b>올해의 문학</b></p>
			<p>
				한강책(괴물아님)
			</p>
			<h2>제일 BOOK 추천도서</h2>
			<img src="/WEB-INF/resources/image/bookimg2.png" alt="bookimg2">
			<p><b>제일 BOOK 추천도서</b></p>
			<p>
				그리스 로마신화
			</p>
			<h2>올해의 BESTSELLER</h2>
			<img src="/WEB-INF/resources/image/bookimg3.png" alt="bookimg3">
			<p><b>올해의 BESTSELLER</b></p>
			<p>
				한강책(진짜 괴물아님)
			</p>
			
			</main>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>