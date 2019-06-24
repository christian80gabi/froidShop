<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 3/12/2019
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>S'identifier - FroidShop International</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>

<%@include file="assets/menu.jsp"%>

<div align="center" style="margin-top: 100px;">
    <div class="inner">
        <h2>identifiez-vous</h2>

        <% if(request.getAttribute("message") != null) { %>
            <p style="color: red">
                <%= request.getAttribute("message") %>
            </p>
        <% } %>

        <% if(request.getAttribute("message2") != null) { %>
            <p style="color: green">
                <%= request.getAttribute("message2") %>
            </p>
        <% } %>

        <form action="login" method="post">

            <div class="field half first">
                <label for="email">Email</label>
                <input name="email" id="email" type="email" placeholder="Email" value="${sessionScope.emailCustomer}" required>

            </div>
            <div class="field half">
                <label for="password">Mot de passe</label>
                <input name="password" id="password" type="password" placeholder="Mot de passe" value="${sessionScope.passwordCustomer}" required>
            </div>
            <ul class="actions">
                <li><input value="Confirmer" class="button" type="submit"></li>
            </ul>
        </form>
    </div>
</div>

<%@include file="assets/scripts.jsp"%>

</body>
</html>