<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>User Info</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div>

            <h1>User Info</h1>

            <p>ID: ${requestScope.user.id}</p>
            <p>First Name: ${requestScope.user.fname}</p>
            <p>Last Name: ${requestScope.user.lname}</p>
            <p>Email: ${requestScope.user.email}</p>
            <p><a href="${pageContext.request.contextPath}/users">To Main</a></p>
        </div>
    </body>
</html>
