<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit User</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
        <div>
            <h1>Edit User</h1>

            <form action="${pageContext.request.contextPath}/edit?id=${requestScope.user.id}" method="post">
                <p>ID: ${requestScope.user.id}</p>
                <p><label>First Name: <input type="text" name="fname" value="${requestScope.user.fname}"></label></p>
                <p><label>Last Name: <input type="text" name="lname" value="${requestScope.user.lname}"></label></p>
                <p><label>Email: <input type="text" name="email" value="${requestScope.user.email}"></label></p>
                <p><input type="submit" value="Save"></p>
            </form>

            <p><a href="${pageContext.request.contextPath}/users">Cancel</a></p>
        </div>
    </body>
</html>
