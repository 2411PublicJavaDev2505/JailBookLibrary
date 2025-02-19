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
		<link rel="stylesheet" href="../resources/css/list.css">
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
			<form class="search-form" action="/book/search" method="get">
				<select class="search-select" name="searchCondition">
					<option value="bookNo"<c:if test="${searchCondition eq 'bookNo' }">selected</c:if>>번호</option>
					<option value="bookName"<c:if test="${searchCondition eq 'bookName' }">selected</c:if>>제목</option>
				</select>
				<input type="text" class="search-input" name="searchKeyword" placeholder="검색어나숫자입력" value="${searchKeyword }">
				<button type="submit" class="search-button">검색</button> 
			</form>
		</div>
		<section class="board-content">
			<table class="book-table">
			<thead>
				<tr>
					<th class="bookNo">번호</th>
					<th class="bookName">제목</th>
					<th class="bookWrite">글쓴이</th>
					<th class="bookPrice">가격</th>
					<th class="publisher">출판사</th>
					<th class="genre">장르</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${searchList }" var="book" varStatus="i">
					<tr>
						<td class="bookNo">${bList.size() -i.index }</td>
						<td><a href="/book/detail?bookNo=${book.bookNo }">${book.bookName }</a></td>
						<td class="bookWrite">${book.bookWrite }</td>
						<td class="bookPrice">${book.bookPrice }</td>
						<td class="publisher">${book.publisher }</td>
						<td class="genre">${book.genre }</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
				<div class="pagination">
				<c:if test="${startNavi ne 1}">
					<a href="/book/list?currentPage=${startNavi -1 }" class="prev">&lt;</a>
				</c:if>
					<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
						<a href="/book/list?currentPage=${p }">${p }</a>
					</c:forEach>
					<c:if test="${endNavi ne 24}">
						<a href="/book/list?currentPage=${endNavi +1 } "class="next">&gt;</a>
					</c:if>
				</div>
			</section>	
		</main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
	</body>
</html>