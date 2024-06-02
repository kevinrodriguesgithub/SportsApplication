<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>
    <h1>User Dashboard</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/sportsApp/allMatches">View All Matches</a></li>
        <li><a href="${pageContext.request.contextPath}/players/all">View All Players</a></li>
        <li><a href="${pageContext.request.contextPath}/teams/allTeams">View All Teams</a></li>
    </ul>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>
