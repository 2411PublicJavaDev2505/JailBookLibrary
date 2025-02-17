<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제일 BOOK - 대여 목록 삭제</title>
</head>
<body>
 	<jsp:include page="/WEB-INF/views/include/header.jsp" />
 	
	<h1>대여 목록 삭제</h1>
	<form class="library-form" action ="/library/delete" method = "post">
	<label>대여번호</label>
				<input type="number" name="leaseNo">
				
	<button type="submit" class="save-button">삭제</button>
	</form>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />			
</body>
</html>