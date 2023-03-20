<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="edit" method="POST">
    <c:if test="${!empty task.description}">
        <input type="hidden" name="id" value="${task.id}">
    </c:if>
    <label for="description">Description</label>
    <input type="text" name="description" id="description" value="${task.description}">
    <label for="status">Status</label>
    <select id="status" name="status">
        <c:forEach var="status" items="${statuses}">
            <option value="${status}" ${status==task.status?"selected":""}>${status}</option>
        </c:forEach>
    </select>
    <input type="submit" value="edit"></td>
</form>
</body>
</html>