<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
        <div>
            <h1>User Database</h1>

            <form action="${pageContext.request.contextPath}/search_user">
                <label><input type="number" name="id" placeholder="Enter ID"></label>
                <input type="submit" value="Search">
            </form>

            <a href="${pageContext.request.contextPath}/add_user">Add User</a><br>

            <table>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${requestScope.userList}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.fname}</td>
                        <td>${user.lname}</td>
                        <td>${user.email}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/edit_user?id=${user.id}">Edit</a>
                            <a href="${pageContext.request.contextPath}/delete_user?id=${user.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>