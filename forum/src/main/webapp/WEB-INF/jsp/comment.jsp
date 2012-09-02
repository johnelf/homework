<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 9/2/12
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment Successfully</title>
</head>
<body>
<p>评论成功...</p>

<a href="OpenSubject.do?name=<%=request.getAttribute("filename")%>">返回原帖</a>
<br/>
<a href="ShowFile.do">返回首页</a>

<%--<form action="ShowFile.do" method="get" title="跳转首页">--%>
    <%--<input type="submit" value="跳转到首页" style="width:70px;height:20px">--%>
<%--</form>--%>
<%--<form action="OpenSubject.do?name=" method="get" title="回到原帖">--%>
    <%--<input type="submit" value="回到原帖" style="width:70px;height:20px">--%>
<%--</form>--%>

</body>
</html>