<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
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
    <form:select path="author" items="${authors}"/>
    categories
    <form:select path="categories" items="${categories}"/>
    content:
    <form:input path="content"/>

    <input type="submit" value="submit">

</form:form>
</body>
</html>