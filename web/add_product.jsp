<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 3/19/2019
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Product - FroidShop International</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>

<%@include file="assets/menu_admin.jsp"%>

<div align="center" style="margin-top: 100px;">
    <div class="inner">
        <h2>Ajouter un produit</h2>

        <c:if test="${!empty adding}">
            <p style="color: green">
                <c:out value="${adding}"/>
            </p>
        </c:if>

        <c:if test="${!empty message2}">
            <p style="color: red">
                <c:out value="${message2}"/>
            </p>
        </c:if>

        <c:if test="${!empty image}">
            <p style="color: green">
                <c:out value="L'image: ${image} a été uploadé !"/>
            </p>
        </c:if>

        <form action="add_product" method="post" enctype="multipart/form-data">

            <div class="field">
                <label for="description">Description</label>
                <input name="description" id="description" type="text" placeholder="Description du produit" required>
            </div>
            <div class="field half first">
                <label for="price">Prix</label>
                <input id="price" name="price" type="text" placeholder="Prix du produit" required>
            </div>
            <div class="field half">
                <label for="quantity">Quantite</label>
                <input name="quantity" id="quantity" type="number" placeholder="Quantite en stock" required>
            </div>
            <div class="field">
                <label for="category">Categorie</label>
                <select id="category" name="category" required>
                    <optgroup label="categories">
                        <c:forEach items="${list}" var="cat" varStatus="index">
                            <option id="${cat}"><c:out value="${cat}"/></option>
                        </c:forEach>
                    </optgroup>
                </select>
            </div>
            <div class="field">
                <label for="file">Image</label>
                <input id="file" type="file" name="image">
            </div>
            <ul class="actions">
                <li><input value="Confirmer" class="button" type="submit"></li>
                <li><input value="clean" class="button alt" type="reset"></li>
            </ul>
        </form>
    </div>
</div>

<%@include file="assets/scripts.jsp"%>

</body>
</html>