<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Successfully Post</title>
</head>
<body>
<p>redirecting in 2s...</p>

<form name="form1" method="GET" action="ShowFile.do" onsubmit="return (this)">
    <script>
        function sub() {
            document.form1.submit();
        }
        setTimeout(sub, 2000);
    </script>
</form>
</body>
</html>
