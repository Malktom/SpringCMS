<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table {
        border-collapse: collapse;
        /*width: 100%;*/
    }
    th, td {
        text-align: left;
        padding: 8px;
    }
    tr:nth-child(even){background-color: #f2f2f2}
    th {
        background-color: #04AA6D;
        color: white;
    }
</style>
<body>
<a href="<c:url value="/category/add"/>">add category</a>
<a href="<c:url value="/article/list"/>">article list</a>
<a href="<c:url value="/author/list"/>">author list</a>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>description</th>

    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>

            <td>
                <a href="<c:url value="/category/delete/${category.id}"/>">delete</a>
                <a href="<c:url value="/category/edit/${category.id}"/>">edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
