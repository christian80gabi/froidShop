<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 3/7/2019
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <!--link font awesome-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/v4-shims.css">
    <!--link the icon-->
    <link rel="shortcut icon" href="#">
    <title>Admin Login</title>
    <!--link CSS file into my JSP page-->
    <link rel="stylesheet" href="assets/css/style_login_admin.css">
</head>
<body>
<form method="post" action="admin">
<div class="login-box">

    <c:if test="${!empty message}">
        <p style="color: #f52f2f">
            <c:out value="${message}"/>
        </p>
    </c:if>

    <c:if test="${!empty message2}">
        <p style="color: green">
            <c:out value="${message2}"/>
        </p>
    </c:if>

    <h1>Admin : Login</h1>
    <div class="textbox">
        <i class="fas fa-user-cog"></i>
        <input type="text" placeholder="Username" name="username" value="${sessionScope.username}" required>
    </div>

    <div class="textbox">
        <i class="fas fa-lock"></i>
        <input type="password" placeholder="Password" name="password" value="${sessionScope.password}" required>
    </div>

    <input class="btn" type="submit" name="" value="Sign In">
</div>
</form>
</body>
</html>