<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

	$(document).ready(function() {
		$('#sing_up').click(function(){
			
			$(location).attr('href', './singUp');
		});

		$('#main_login_button').click(function() {
			var id = $('#main_id').val();
			var pw = $('#main_pw').val();
			
			$(location).data("id", id);
			$(location).data("pw", pw);
			
			$(location).attr('href', './login');
		});
		
/* 		$('#main_login_button').on('click', function() {
			alert('버튼 ㅇㅇㅇㅇ');
		}); */
	});
</script>
</head>


<body style="width: 800px; margin: 0 auto;">
	<div style="margin: 0 auto; width: 50%; height: 50%">
		<div style="height: 200px;"></div>
		<div ></div>
		
		
 		<form action="login" method="post">
	 		<table style="border: 1px solid gray;">
				<tr>
					<td>아이디</td>
					<td>
						<input name="mem_id" type="text">
					</td>
				</tr>			
				<tr>
					<td>비밀번호</td>
					<td>
						<input name="mem_password" type="password">
					</td>
				</tr>
				<tr>
					<td>
						<input id="main_login_button" type="submit" value="로그인">
					</td>
					<td>
						<input id="sing_up" type="button" value="회원가입">
					</td>
				</tr>
				<tr>
					<td>
					</td>
				</tr>		
			</table>
		</form>
						<a href="users/naverlogin">네이버로 로그인</a>
		
			<c:if test="${error != null}">
				<p style="font-size: 10px; color: red; ">
					${error }
				</p>
			</c:if>
			
<%--  
 			<form:form commandName="m" action="login" method="post">
				<form:input path="mem_id"/>
				<form:password path="mem_passward"/>
				<input type="submit" value="login">
			</form:form>
 --%>
 			
		<c:forEach items="${mem}" var="mem">
			<tr>
				<td>${mem.mem_num}</td>
				<td>${mem.mem_id}</td>
				<td>${mem.mem_passward}</td>
			</tr>
		</c:forEach>
	</div>
</body>
</html>