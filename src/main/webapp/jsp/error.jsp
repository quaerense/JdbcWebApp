<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Error</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
        <div>
            <h1>User with ID ${requestScope.id} does not exist</h1>

            <p><a href="${pageContext.request.contextPath}/users">To Main</a></p>
        </div>
    </body>
</html>
