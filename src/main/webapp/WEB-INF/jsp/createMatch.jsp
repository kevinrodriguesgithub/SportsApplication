<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create IPL Match</title>
</head>
<body>
    <h2>Create New IPL Match</h2>
    <form action="${pageContext.request.contextPath}/sportsApp/match" method="post">
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required><br>        
        
        <label for="teamA">Team A:</label>
        <select name="teamA" id="teamA" required>
            <c:forEach items="${teams}" var="team">
                <option value="${team.id}">${team.name}</option>
            </c:forEach>
        </select><br>

        <label for="teamB">Team B:</label>
        <select name="teamB" id="teamAB" required>
            <c:forEach items="${teams}" var="team">
                <option value="${team.id}">${team.name}</option>
            </c:forEach>
        </select><br>

        <label for="players">Players:</label>
        <select multiple="multiple" name="playerIds" required>
	        <c:forEach items="${players}" var="player">
	            <option value="${player.id}">${player.name}</option>
	        </c:forEach>
    	</select>
        <br>
        
        
        <label for="venue">Venue:</label>
        <input type="text" id="venue" name="venue" required><br>
        
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required><br>
        
        <button type="submit">Create Match</button>
    </form>
</body>
</html>
