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
	<div class="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main>
			<section class="border-title">			
				<h1>대여관리</h1>
				<a href="/library/write">대여 등록</a>
				<a href="/library/delete">대여 삭제</a>
			</section>
			<div class="search-container">
					<form class="search-form" action="/library/search" method="get">
						<select class="search-select" name="searchCondition">
							<option value="userId">회원ID</option>
							<option value="bName">책제목</option>
						</select>
						<input type="text" class="search-input" name="searchKeyword" placeholder="검색어를 입력하세요">
						<button type="submit" class="search-button">검색</button>
					</form>
				</div>
			<section class="border-content">
				<table>
					<thead>
						<tr>
							<th class="lNum">대여번호</th>
							<th class="bName">책제목</th>
							<th class="userId">고객ID</th>
							<th class="lDate">대여일</th>
							<th class="rDate">반납일</th>
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
							<td class="rDate">${library.returnDate }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>			
			</section>
		</main>		
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>	
	</div>
</body>
</html>