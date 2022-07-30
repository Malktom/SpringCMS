<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/author/add"/>">add author</a>

<table>
    <tr>
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>

    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>

            <td>
                <a href="<c:url value="/author/delete/${author.id}"/>">usuń</a>
                <a href="<c:url value="/author/edit/${author.id}"/>">edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
