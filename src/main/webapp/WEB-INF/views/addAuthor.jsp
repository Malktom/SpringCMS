<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <form:hidden path="id"/>
    name:
    <form:input path="firstName"/>
    description:
    <form:input path="lastName"/>

    <input type="submit" value="submit">

</form:form>
</body>
</html>