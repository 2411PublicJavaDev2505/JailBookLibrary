<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원관리</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        h2 {
            text-align: center;
        }
        form {
            width: 80%;
            margin: 20px auto;
        }
        input[type="text"], input[type="password"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            margin: 5px 0;
            border: none;
            cursor: pointer;
        }
    </style>
	
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
</head>
	<body>
		<div id="container">
				<jsp:include page="/WEB-INF/views/include/header.jsp"/>
		<main>
		    <h2>회원관리</h2>
		    <form action="/customer/search" method="get">
		        <label for="userName">이름으로 검색</label>
		        <input type="hidden" name="searchCondition" value="userName">
		        <input type="text" id="userName" name="searchKeyword">
		        <input type="submit" value="검색">
		    </form>
		
		    <form action="/customer/search" method="get">
		    	<input type="hidden" name="searchCondition" value="userId">
		        <label for="userId">아이디로 검색</label>
		        <input type="text" id="userId" name="searchKeyword">
		        <input type="submit" value="검색">
		    </form>
		
		    <h2>회원 전체 조회</h2>
			<section class="board-content">
			<table class="userId">
		        <thead>
		            <tr>
		                <th>고객번호</th>
		                <th>아이디</th>
		                <th>비밀번호</th>
		                <th>이름</th>
		                <th>나이</th>
		                <th>주소</th>
		                <th>성별</th>
		                <th>가입일</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach var="Customer" items="${cList}" >
		                <tr>
		                    <td>${Customer.userId} </td>
		                    <td><a href="/customer/detail?userId=${Customer.userId }">${Customer.userPw}</a></td>
		                    <td>${Customer.userName}</td>
		                    <td>${Customer.userAge}</td>
		                    <td>${Customer.addr}</td>
		                    <td>${Customer.gender}</td>
		                    <td>${Customer.enrollDate}</td>
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
							
	        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
	    
	</body>
</html>