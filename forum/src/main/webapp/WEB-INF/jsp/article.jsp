<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 9/2/12
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        <c:out value="${name}"/>
    </title>
</head>
<body>
<c:forEach var="art" items="${art}">
    <c:out value="${art}"/><br/>
</c:forEach>
<c:forEach var="comment" items="${comment}" varStatus="status">
    <c:out value="${status.count} : ${comment}"/><br/>
</c:forEach>

<p>添加评论：</p>

<form action="AddComment.do?filename=${name}" method="post" title="发布主题">
    <textarea name="comment" rows="4" cols="120"></textarea> <br/>
    <input type="submit" value="发布" style="width:50px;height:20px">
</form>
</body>
</html>