<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Add User</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
        <div>
            <h1>Add User</h1>

            <form action="${pageContext.request.contextPath}/save" method="post" accept-charset="UTF-8">
                <p><label>First Name: <input type="text" name="fname"></label></p>
                <p><label>Last Name: <input type="text" name="lname"></label></p>
                <p><label>Email: <input type="text" name="email"></label></p>
                <p><input type="submit" value="Save"></p>
            </form>

            <p><a href="${pageContext.request.contextPath}/users">Cancel</a></p>
        </div>
    </body>
</html>
