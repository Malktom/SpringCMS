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
</head>
<body>
<table>
    <tr>
        <th>name</th>
        <th>description</th>


    </tr>
    <c:forEach items="${categoriesList}" var="cat">
        <tr>

            <td><a href="<c:url value="/article/${cat.name}"/>"> ${cat.name}</a></td>
            <td>${cat.description}</td>


        </tr>

    </c:forEach>

</table>
</body>
</html>
