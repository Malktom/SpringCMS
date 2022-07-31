<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table {
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid grey;
    }
    th, td {
        text-align: center;
        padding: 6px;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>
<body>
<a href="<c:url value="/author/add"/>">add author</a>
<a href="<c:url value="/article/list"/>">article list</a>
<a href="<c:url value="/category/list"/>">category list</a>

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
                <a href="<c:url value="/author/delete/${author.id}"/>">delete</a>
                <a href="<c:url value="/author/edit/${author.id}"/>">edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
