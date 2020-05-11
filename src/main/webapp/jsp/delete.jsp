<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Delete User</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div>

            <h1>Delete This User?</h1>

            <form action="${pageContext.request.contextPath}/delete" method="post">
                <p><label>ID: <input type="number" name="id" value="${requestScope.user.id}" readonly></label></p>
                <p>First Name: ${requestScope.user.fname}</p>
                <p>Last Name: ${requestScope.user.lname}</p>
                <p>Email: ${requestScope.user.email}</p>
                <p><input type="submit" value="Delete"></p>
            </form>
            <p><a href="${pageContext.request.contextPath}/users">Cancel</a></p>
        </div>
    </body>
</html>
