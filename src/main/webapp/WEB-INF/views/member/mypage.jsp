<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>마이페이지</h1>
		<fieldset>
			<legend>마이페이지</legend>
			<table>
				<tr>
					<th>아이디</th>
					<td>${memberId }</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${memberName }</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>${mOne.memberAge }</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${mOne.memberGender }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${mOne.memberEmail }</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${mOne.memberPhone }</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${mOne.memberAddr }</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>${mOne.memberHobby }</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${mOne.memberDate }</td>
				</tr>
			</table>
		</fieldset>
		<a href="/index.jsp">메인으로 이동</a>
		<a href="/member/update.do?memberId=${memberId }">수정하기</a>
		<a href="/member/delete.do?memberId=${memberId }">삭제하기</a>
	</body>
</html>