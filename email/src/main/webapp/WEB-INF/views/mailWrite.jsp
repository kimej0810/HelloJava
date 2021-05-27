<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/writeAction">
	수신자 이메일<input type="text" name="address"><br>
	제목<input type="text" name="title"><br>
	내용<textarea rows="5" cols="80" name="message"></textarea><br>
	<input type="submit" value="전송">
</form>
</body>
</html>