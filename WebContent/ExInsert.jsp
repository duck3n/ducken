<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
	table, tr, th, td {
		margin: 0 auto;
		border: 1px solid black;
		border-collapse: collapse;
		padding : 20px;
	}
	
	table { width: 800px;}
</style>
</head>
<body>
	<div>
		<form action="insert.do" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" id="" />
						<c:if test="${errors.id }">ID를 입력하세요</c:if>
						<c:if test="${errors.duplicated }">이미 사용중인 아이디입니다</c:if>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" id="" />
						<c:if test="${errors.name }">이름을 입력하세요</c:if>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="text" name="pass" id="" />
						<c:if test="${errors.password }">패스워드를 입력하세요</c:if>
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>
						<input type="text" name="confirmPass" id="" />
						<c:if test="${errors.confirmPassword }">패스워드를 한번 더 입력하세요</c:if>
						<c:if test="${errors.notEqual }">암호가 서로 일치하지 않습니다</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록" />
						<input type="reset" value="reset" />
					</td>
				</tr>				
			</table>	
		
		</form>	
	</div>
</body>
</html>











