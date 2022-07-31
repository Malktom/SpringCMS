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
<a href="<c:url value="/article/add"/>">add article</a>
<a href="<c:url value="/author/list"/>">author list</a>
<a href="<c:url value="/category/list"/>">category list</a>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>author</th>
        <th>categories</th>
        <th>content</th>
        <th>created</th>
        <th>updated</th>

    </tr>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.author}</td>
<%--            <td>${article.categories}</td>--%>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>

            <td>
                <a href="<c:url value="/article/delete/${article.id}"/>">delete</a>
                <a href="<c:url value="/article/edit/${article.id}"/>">edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
