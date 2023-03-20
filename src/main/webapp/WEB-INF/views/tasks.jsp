<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TASKS</title>
</head>
<body>

<h2>TASKS</h2>
<table border="1" cellpadding="5">
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

<br>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/" var="url">
        <c:param name="page" value="${i.index}"/>
        <c:param name="size" value="5"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<h2>Add</h2>
<a href="/add">Add new task</a>
</body>
</html>
