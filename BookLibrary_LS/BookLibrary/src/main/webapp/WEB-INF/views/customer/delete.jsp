<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>

</head>
<body>
	<form action="/customer/delete" method="get">
        <h3>회원 탈퇴</h3>
        <input type="text" name="action" value="delete">
        <label for="deleteUserId">아이디</label>
        <input type="text" id="deleteUserId" name="userId" required>

        <input type="submit" value="회원 탈퇴">
    </form>

</body>
</html>