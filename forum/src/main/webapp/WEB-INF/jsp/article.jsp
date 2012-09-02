<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 9/2/12
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%=request.getAttribute("name")%>
    </title>
</head>
<body>
<%
    ArrayList art = (ArrayList) request.getAttribute("art");
    ArrayList comment = (ArrayList) request.getAttribute("comment");

    for (int i = 0; i < art.size(); i++) {
        out.println(art.get(i) + "</br>");
    }
    out.print("</br>");
    out.print("</br>");
    for (int j = 0; j < comment.size(); j++) {
        out.println(Integer.toString(j) + " Floor: " + comment.get(j) + "</br>");
    }
%>

<p>添加评论：</p>
<form action="AddComment.do?filename=<%=request.getAttribute("name")%>" method="post" title="发布主题">
    <textarea name="comment" rows="4" cols="120"></textarea> <br/>
    <input type="submit" value="发布" style="width:50px;height:20px">
</form>
</body>
</html>