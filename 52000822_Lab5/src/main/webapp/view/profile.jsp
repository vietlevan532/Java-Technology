<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Hello TDTU </h1>
<%
    int id=Integer.valueOf(request.getParameter("id"));
    String name=request.getParameter("name");
%>
<p>Id của bạn là: <%=id %></p>
<p>Tên của bạn là: <%=name %></p>
</body>
</html>
