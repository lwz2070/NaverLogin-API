<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/session.js" ></script>
<script type="text/javascript">
</script>
   
</head>
<body style="width: 800px; margin: 0 auto;">
	<div style="margin: 0 auto; width: 65%; height: 50%">
		<div style="height: 200px;"></div>
		
		<form  action="joinUpComplete" method="post">	
			<table>
				<tr> 
					<td>아이디</td>
					<td>
						<input id="join_id" type="text" name="mem_id">
					</td>
					<td>
						<input id="checkId" type="button" value="중복확인">
					</td>
					<td>
						<p id="massegeId" style="font-size: 10px;">
						</p>
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
						<input id="join_nick" type="text" name="mem_nick">
					</td>
					<td>
						<input id="checkNick" type="button" value="중복확인">
					</td>
					<td>
						<p id="massegeNick" style="font-size: 10px;">
						</p>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input id="join_pw" type="password" name="mem_password">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input id="join_pw_check" type="password">
					</td>
				</tr>
				<tr>
					<td>
						<input id="join_btn" type="submit" value="회원가입" disabled="disabled">
					</td>
				</tr>
			</table>	
		</form>
	</div>
</body>
</html>