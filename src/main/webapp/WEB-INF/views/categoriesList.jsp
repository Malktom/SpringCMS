<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/category/add"/>">add category</a>

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
                <a href="<c:url value="/category/delete/${category.id}"/>">usuń</a>
                <a href="<c:url value="/category/edit/${category.id}"/>">edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
