<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제일 BOOK</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main id="main">
			<div class="area1">
			<!-- <h2>올해의 작가</h2> -->
			<img src="../resources/image/writerimg.png" alt="writer">
			<p><b>올해의 작가</b></p>
			<p>
				한강(강 아님)
			</p>
			</div>
			<div class="area2">
			<!-- <h2>올해의 문학</h2> -->
			<img src="../resources/image/bookimg1.png" alt="bookimg1">
			<p><b>올해의 문학</b></p>
			<p>
				한강책(괴물아님)
			</p>
			</div>
			<div class="area3">
			<!-- <h2>제일 BOOK 추천도서</h2> -->
			<img src="../resources/image/bookimg2.png" alt="bookimg2">
			<p><b>제일 BOOK 추천도서</b></p>
			<p>
				그리스 로마신화
			</p>
			</div>
			<div class="area4">
			<!-- <h2>올해의 BESTSELLER</h2> -->
			<img src="../resources/image/bookimg3.png" alt="bookimg3">
			<p><b>올해의 BESTSELLER</b></p>
			<p>
				한강책(진짜 괴물아님)
			</p>
			</div>
		</main>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>