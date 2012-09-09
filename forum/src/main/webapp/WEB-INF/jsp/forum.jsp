<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="Page-Exit" Content="blendTrans(Duration=0.5)">
    <title>TW Forum</title>
</head>
<body>
<p>This is a Public Forum!</p>
<img src="image/o_TWLogo.jpeg" width="200" height="70" alt="论坛首页">
<br/>

<p>发布主题</p>

<form action="PostSubject.do" method="post" title="发布主题">
    <textarea name="subject" rows="1" cols="80"></textarea> <br/>
    <textarea name="context" rows="4" cols="120"></textarea> <br/>
    <input type="submit" value="发布" style="width:50px;height:20px">
</form>
<br/>

<p>热门话题</p>
<c:forEach var="topic" items="${topics}">
    <a href="OpenSubject.do?name=${topic}">${topic}</a><br/>
</c:forEach>

</body>
</html>
