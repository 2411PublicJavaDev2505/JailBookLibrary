<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제일 book - 전체책 검색</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
		<link rel="stylesheet" href="../resources/css/booklist.css">
	</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
		<main>
			<section class="board-title">
				<h1>책관리</h1>
			<a href="/book/write">책등록</a>
			</section>
			<div class="search-container">
			<form class="search-form" action="#" method="get">
				<select class="search-select" name="searchCondition">
					<option value="bookNo">책번호</option>
					<option value="bookName">제목</option>
				</select>
				<input type="text" class="search-input" name="searchkeyword">
				<button type="submit" class="search-button">검색</button> 
			</form>
		</div>
		<section class="board-content">
			<table class="book-table">
			<thead>
				<tr>
					<th class="bookNo">번호</th>
					<th class="name">제목</th>
					<th class="write">글쓴이</th>
					<th class="price">가격</th>
					<th class="publisher">출판사</th>
					<th class="genre">장르</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bList }" var="book" varStatus="i">
					<tr>
						<td class="bookNo">${bList.size() -i.index }</td>
						<td><a href="/book/detail?bookNo=${book.bookNo }">${book.bookName }</a></td>
						<td class="write">${book.bookWrite }</td>
						<td class="price">${book.bookPrice }</td>
						<td class="publisher">${book.publisher }</td>
						<td class="genre">${book.genre }</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
				<div class="pagination">
					<a href="#" class="prev">&lt;</a>
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#" class="next">&gt;</a>
				</div>
			</section>	
		</main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
	</body>
</html>