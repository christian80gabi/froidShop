<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 3/12/2019
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>S'inscrire - FroidShop International</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>

<%@include file="assets/menu.jsp"%>

<div align="center" style="margin-top: 100px;">
    <div class="inner">
        <h2>Vos Informations</h2>

        <% if (request.getAttribute("message2") != null) { %>
            <p style="color: red">
                <%= request.getAttribute("message2") %>
            </p>
        <% } %>

        <form action="inscription" method="post">

            <div class="field half first">
                <label for="prenom">Prenom</label>
                <input name="prenom" id="prenom" type="text" placeholder="Prenom" required>
            </div>
            <div class="field half">
                <label for="nom">Nom</label>
                <input name="nom" id="nom" type="text" placeholder="Nom" required>
            </div>
            <div class="field">
                <label for="email">Email</label>
                <input name="email" id="email" type="email" placeholder="Email" required>
            </div>
            <div class="field half first">
                <label for="password">Mot de passe</label>
                <input id="password" name="password" type="password" placeholder="Mot de passe" required>
            </div>
            <div class="field half">
                <label for="confPassword">Confirmer le Mot de passe</label>
                <input id="confPassword" name="confPassword" type="password" placeholder="Entrez de nouveau le Mot de passe" required>
            </div>
            <div class="field">
                <label for="tel">Telephone</label>
                <input id="tel" name="tel" type="number" maxlength="8" placeholder="Numero de telephone">
            </div>
            <ul class="actions">
                <li><input type="submit" value="Confirmer" class="button"></li>
                <li><input type="reset" value="Annuler" class="button alt"></li>
            </ul>
        </form>
    </div>
</div>

<%@include file="assets/scripts.jsp"%>

</body>
</html>