<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>제일 BOOK - 대여 관리</title>
</head>
<body>
	<div id="container">
	 <jsp:include page="/WEB-INF/views/include/header.jsp" />
	 <main>
	<h1>대여 관리 작성</h1>
	
		<form class="library-form" action ="/library/write" method = "post">
			<h2>대여 목록 작성</h2>	
			<div class="form-group">
				<label>대여번호</label>
				<input type="number" name="leaseNo">
			</div>
			<div class="form-group">
				<label>책제목</label>
				<input type="text" name="bookName">
			</div>
			<div class="form-group">
				<label>고객ID</label>
				<input type="text" name="userId">
			</div>
			<button type="submit" class="save-button">저장</button>
		</form>
		</main>
	 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
	 </div>		
</body>
</html>