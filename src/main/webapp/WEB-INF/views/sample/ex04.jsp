<%--
  Created by IntelliJ IDEA.
  User: Dayeon'
  Date: 2024-06-04
  Time: 오후 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${todoDTO.title}</h1>
    <h4>${todoDTO.dueDate}</h4>
    <h1>page = ${page}</h1>
    <hr/>
    <p>${todoDTO}</p>
<%--    <h1>${list}</h1>--%>
</body>
</html>
