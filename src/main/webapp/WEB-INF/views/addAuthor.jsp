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
    firstName:
    <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error-class"/>
  lastName:
    <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error-class"/>


    <input type="submit" value="submit">

</form:form>
</body>
</html>