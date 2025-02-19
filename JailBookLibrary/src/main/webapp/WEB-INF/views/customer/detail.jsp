<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제일BOOK-회원정보 상세 </title>
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
</head>	

	<body>
			<div>
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			<main>
				
					<div >
						<h2 >${Customer.userId }</h2>
						<div >
							<span>비밀번호 : ${Customer.userPw }</span>
							<span>이름 : ${Customer.userName }</span>
							<span>나이 : ${Customer.userAge }</span>
							<span>주소  : ${Customer.addr }</span>
							
						</div>
					</div>
					
				<div >
					<div class="admin-button">
						<a href="/customer/update?userId=${Customer.userId }" class="btn btn-admin">수정</a>
						<a href="/customer/delete?userId=${Customer.userId }" class="btn btn-admin">삭제</a>
					</div>
					<div class="navigation-buttons">
						<a href="/customer/list" class="btn">목록</a>
						<a href="#" class="btn"> 이전 </a>
						<a href="#" class="btn">다음</a>
					</div>
				</div>
			</main>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
	
	</body>
</html>