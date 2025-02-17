<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원 검색</title>
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
    <h2>회원 검색</h2>
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

    <c:if test="${not empty searchList}">
        <h2>검색 결과</h2>
        <table>
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
                <c:forEach var="customer" items="${cList}">
                    <tr>
                        <td>${customer.userNo}</td>
                        <td>${customer.userId}</td>
                        <td>${customer.userName}</td>
                        <td>${customer.userAge}</td>
                        <td>${customer.addr}</td>
                        <td>${customer.gender}</td>
                        <td>${customer.enrollDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        	<div class="pagination">
					<c:if test="${startNavi ne 1 }">
						<a href="/customer/search?currentPage=${startNavi -1 }" class="prev">&lt;</a>
					</c:if>	
					<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
						<a href="/customer/search?currentPage=${p }" <c:if test="${currentPage == p }">style="color: #fff; background-color:#2d336a;"</c:if>>${p }</a>
					</c:forEach>
					<c:if test="${endNavi ne maxPage }">
						<a href="/customer/search?currentPage=${endNavi +1}" class="next">&gt;</a>
					</c:if> 
			  </div>
    </c:if>
    
    <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>