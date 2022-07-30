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
<%--    jak dodac nazwisko do selecta--%>
    <form:select itemValue="id" itemLabel="lastName" path="author.id" items="${authors}"/>
    categories
    <form:checkboxes itemValue="id" itemLabel="name" path="category.id" items="${categories}"/>
    content:
    <form:input path="content"/>

    <input type="submit" value="submit">

</form:form>
</body>
</html>