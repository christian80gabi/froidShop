<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 3/16/2019
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Categories - FroidShop International</title>
    <link rel="stylesheet" href="assets/css/main.css"/>
</head>
<body>

<%@include file="assets/menu_admin.jsp" %>

<div align="center" style="margin-top: 100px;">
    <h4>Nouvelle Categorie</h4>

    <p style="color: #f52f2f">
        <c:if test="${!empty message}">
            <c:out value="${message}"/>
        </c:if>
    </p>
    <form action="categories" method="post">
        <div class="table-wrapper">
            <table class="alt">
                <thead>
                <tr>
                    <th><label for="cat">Nom de la categorie : </label></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <input id="cat" type="text" name="name" required>
                    </td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td><input type="submit" value="confirmer"></td>
                </tr>
                </tfoot>
            </table>
        </div>
    </form>
</div>

<div align="center" style="margin-top: 100px;">
    <h4>Categories</h4>
    <div class="table-wrapper">
        <table class="alt">
            <thead>
            <tr>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="cat" varStatus="inxex">
                <tr>
                    <td><c:out value="${inxex.count}"/></td>
                    <td><c:out value="${cat}"/></td>
                    <td><a href="#">supprimer</a> / <a href="#">modifier</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td>end</td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>

<%@include file="assets/scripts.jsp" %>
</body>
</html>
