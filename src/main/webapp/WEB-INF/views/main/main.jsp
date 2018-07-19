<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="width: 800px; margin: 0 auto;">
	<div style="margin: 0 auto; width: 65%; height: 50%">
		<div style="height: 200px;"></div>
		
		<h1>메인입니다.</h1>
		<h2>파일 업로드</h2>
		
		<!-- enctype="multipart/form-data" 이 구문이 있어야 파일을 전송 할 수 있음 -->
		<form action="fileUpload" method="post" enctype="multipart/form-data">
		
			<table>
				<tr>
					<td>파일 업로드</td>
					<!-- type="file" 파일 업로드할 수 있게 만들어줌 -->
					<td>
						<input type="file" name="multiFile">
					</td>
				</tr>
				<tr>
					<td>
						
					</td>
					<td>
						<input type="submit" value="업로드">
					</td>
				</tr>
			</table>
		</form>
		
		<a href="fileList">파일 리스트 보기</a>
		
		
		
	</div>
</body>
</html>