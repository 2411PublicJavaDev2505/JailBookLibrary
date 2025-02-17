<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제일BOOK-회원정보 상세 </title>
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
</head>	

	<body>
			
				<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
				
					<form action="/customer/update" method="post">
					
						
							<h2 >${customer.userId }</h2>
							
								<span>이름 : ${customer.userName }</span>
								<span>나이 : ${customer.userAge }</span>
								<span>주소  : ${customer.addr }</span>
								
							
				<table>	
				<tr>
					<td>고객번호</td>
					<td><input type="text" value="${customer.userNo }" name="userNo" readonly></td>
				</tr>
				<tr>
					<td>고객아이디</td>
					<td><input type="text" value="${customer.userId }" readonly ></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" value="${customer.userName }" name="userName" ></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" value="${customer.userAge }" readonly ></td>
				</tr>				
				<tr>
					<td>주소</td>
					<td><input type="text" value="${customer.addr }" name="addr" ></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
							남 : <input type="radio" name="gender" value="${customer.gender }" readonly <c:if test="${customer.gender == 'M' }">checked</c:if>>						
							여 : <input type="radio" name="gender" value="${customer.gender }" readonly <c:if test="${customer.gender == 'F' }">checked</c:if>>
					</td>
				</tr>
				<tr>
					<td>가입일</td>
					<td><input type="text" value="${customer.enrollDate }" readonly ></td>
				</tr>		
				</table>	
					
				<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
				
				<a href="/customer/delete?userId=${customer.userId }"> 탈퇴</a>
			
		</form>
	</body>
</html>