<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <form:hidden path="id"/>
    title:
    <form:input path="title"/>
    author:
    <%--    jak dodac nazwisko do selecta--%>
    <form:select itemValue="id" itemLabel="lastName" path="author.id" items="${authors}"/>
    categories:
    <form:select itemValue="id" itemLabel="name" path="categories" items="${categories}"/>

    content:
    <form:input path="content"/>

    <input type="submit" value="submit">

</form:form>
</body>
</html>