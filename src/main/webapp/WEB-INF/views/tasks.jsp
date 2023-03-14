<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>FILMS</title>
</head>
<body>

<h2>Films</h2>
<table>
    <tr>
        <th>id</th>
        <th>description</th>
        <th>status</th>
    </tr>
    <c:forEach var="task" items="${all}">
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>${task.status}</td>
            <td>
                <a href="/edit/${task.id}">edit</a>
                <a href="/delete/${task.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%--<h2>Add</h2>
<c:url value="/edit" var="add"/>
<a href="${edit}">Add new task</a>--%>
</body>
</html>
