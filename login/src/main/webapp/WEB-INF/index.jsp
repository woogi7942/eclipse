<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="/css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/main/nav.jsp"/>
<jsp:include page="/WEB-INF/${page}"/>
<jsp:include page="/WEB-INF/main/footer.jsp"/>
</body>
</html>