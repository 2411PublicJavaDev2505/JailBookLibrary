<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>대여 정보 검색</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    <h2>대여 정보 검색</h2>
    <div class="search-container">
		<form class="search-form" action="/library/search" method="get">
			<select class="search-select" name="searchCondition">
				<option value="title" <c:if test="${searchCondition eq 'userId' }">selected</c:if>>회원ID</option>
				<option value="content" <c:if test="${searchCondition eq 'bookName' }">selected</c:if>>책제목</option>
			</select>
			<input type="text" class="search-input" name="searchKeyword" placeholder="검색어를 입력하세요" value="${searchKeyword }">
			<button type="submit" class="search-button">검색</button>
		</form>
	</div>
	<section class="board-content">
		<table class="library-table">
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
				<c:forEach items="${searchList }" var="library">
					<tr>
						<td class="lNum">${library.leaseNo}</td>
						<td class="bName">${library.bookName }</td>
						<td class="userId">${library.userId }</td>
						<td class="lDate">${library.leaseDate }</td>
						<td class="rDate">${library.returnDate }</td>
					</tr>					
				</c:forEach>
            </tbody>
        </table>
        <div class="pagination">
			<c:if test="${startNavi ne 1 }">
				<a href="/notice/list?currentPage=${startNavi - 1 }" class="prev">&lt;</a>
			</c:if>
			<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
				<a href="/notice/list?currentPage=${p }">${p }</a>
			</c:forEach>
			<c:if test="${endNavi ne maxPage }">
				<a href="/notice/list?currentPage=${endNavi + 1 }" class="next">&gt;</a>
			</c:if>
		</div>
	</body>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</html>