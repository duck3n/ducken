<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table, tr, td {
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}

table {
	width: 1000px;
}

td {
	width: 200px;
	text-align: center;
}

.explain {
	font-size: 14px;
	color: red;
}

.login a {
	font-weight: bold;
}

a {
	text-decoration: none;
}

td:hover {
	background-color: gray;
	cursor: pointer;
}
</style>

</head>
<body>

	<table>

		<!-- emp : ExLoginAction에서 emp라는 이름의 session 형태로 로그인 정보를 저장해 둠 -->
		<!-- result : ExLoginAction에서 result라는 이름의 session 형태로 권한 정보를 저장해 둠 -->

		<c:if test="${empty emp }">


			<tr>
				<td>로그인 해주세요</td>
				<td>로그인 해주세요</td>
				<td><a href="login.do">로그인</a></td>
				<td>로그인 해주세요</td>
				<td>로그인 해주세요</td>
				<td>로그인 해주세요</td>
			</tr>

		</c:if>


		<c:if test="${!empty emp }">
			<tr>
				<td>${emp.id }님환영합니다!</td>
				<td>사내 공지 메일발송</td>
				<td><a href="logout.do">로그아웃</a></td>
				<td><a href="mypage.do">마이페이지</a></td>
				<c:choose>
					<c:when test="${result == 2 }">
						<td><a href="#">사원등록</a></td>
					</c:when>
					<c:when test="${result == 3 }">
						<td>사원등록은 관리자만 가능</td>
					</c:when>
				</c:choose>
				<td>사내게시판</td>
			</tr>
		</c:if>

	</table>


</body>
</html>