<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Team</title>
</head>
<body>
<h2>Create New Team</h2>
<form:form modelAttribute="team" action="${pageContext.request.contextPath}/teams/newTeam" method="post">
    <form:label path="name">Team Name:</form:label>
    <form:input path="name" required="true" /><br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
