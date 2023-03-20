<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<form action="add" method="POST">
    <label for="description">Description</label>
    <input type="text" name="description" id="description">
    <label for="status">Status</label>
    <select name="status" id="status">
        <option>IN_PROGRESS</option>
        <option>DONE</option>
        <option>PAUSED</option>
    </select>
    <input type="submit" value="add"></td>
</form>

</body>
</html>
