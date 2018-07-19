<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 리스트 보기</title>
	<script type="text/javascript">
		function file(num) {
			$.ajax({
				data : {
					num : num
				},
				url : "./fileDown",
				success : function(data) {
					
				}
			});
		}
	</script>


</head>



<body style="width: 800px; margin: 0 auto;">
	<div style="margin: 0 auto; width: 50%; height: 50%">
		<!-- <div style="height: 200px;"></div> -->


		<c:forEach items="${bean}" var="b">
			<a href="#" onclick="file('${b.file_num}')">${b.file_num}</a>
			<p>${b.file_name}</p>
		</c:forEach>
		
	</div>
</body>
</html>