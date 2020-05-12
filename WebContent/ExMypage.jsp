<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="ExHeader.jsp"></jsp:include>

<form action="./mypage.do" method="post">
	
	<table>
		<tr>
			<th colspan="2">My Page</th>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${emp.id }</td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td>${emp.name }</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td>
			<input type="text" name="pass2" id="" />
			</td>
		</tr>
		
		<tr>
			<td>권한</td>
			
			<c:choose>
				<c:when test="${result == 2 }">
					<td>운영자</td>
				</c:when>
				<c:otherwise>
					<td>일반사원</td>
				</c:otherwise>
			</c:choose>
				
				
			
		
			
		</tr>
		
		<tr>
			<td>성별</td>
			
			<c:choose>
				<c:when test="${emp.gender == 2}">
				<td>여성</td>
				</c:when>
			<c:otherwise>
				<<td>남성</td>
			</c:otherwise>
			</c:choose>
			
		</tr>
		
		<tr>
			<td>전화번호</td>
			<td>
			<input type="text" name="phone" id="" placeholder="${emp.phone }"/>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
			<input type="submit" value="수정" />
			<input type="reset" value="취소" />
			</td>
		</tr>
		
		
		
	</table>
	
	</form>

</body>
</html>