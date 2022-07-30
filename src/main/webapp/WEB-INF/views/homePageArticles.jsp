<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 30.07.2022
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>title</th>
        <th>created</th>
        <th>content</th>

    </tr>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.content}</td>

        </tr>

    </c:forEach>

</table>
</body>
</html>
