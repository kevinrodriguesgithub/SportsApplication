<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create a Player</title>
</head>
<body>
<h2>Create New Player</h2>
<form:form modelAttribute="player" action="${pageContext.request.contextPath}/players/p" method="post">
    <form:label path="name">Name:</form:label>
    <form:input path="name" required="true" /><br/>
    
    <form:label path="jerseyNumber">Jersey Number:</form:label>
    <form:input path="jerseyNumber" required="true" /><br/>

    <form:label path="team">Team:</form:label>
    <form:select path="team" items="${teams}" itemValue="id" itemLabel="name" required="true" />
    <br/>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
