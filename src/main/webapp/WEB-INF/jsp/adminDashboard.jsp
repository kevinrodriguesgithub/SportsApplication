<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h1>Admin Dashboard</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/sportsApp/match/new">Create New Match</a></li>
        <li><a href="${pageContext.request.contextPath}/players/new/p">Create New Player</a></li>
        <li><a href="${pageContext.request.contextPath}/teams/new">Create New Team</a></li>
        <li><a href="${pageContext.request.contextPath}/sportsApp/allMatches">View All Matches</a></li>
        <li><a href="${pageContext.request.contextPath}/players/all">View All Players</a></li>
        <li><a href="${pageContext.request.contextPath}/teams/allTeams">View All Teams</a></li>
    </ul>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>
