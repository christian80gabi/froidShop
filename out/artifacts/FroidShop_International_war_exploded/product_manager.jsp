<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 3/16/2019
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Produits - FroidShop International</title>
    <link rel="stylesheet" href="assets/css/main.css" />
    <meta charset="ISO-8859-1">
</head>
<body>

<%@include file="assets/menu_admin.jsp"%>



<div align="center" style="margin-top: 100px;">
    <h4>Products</h4>
    <p><a href="add_product">ajouter un Produit</a> </p>
    <div class="table-wrapper">
        <table class="alt">
            <thead>
            <tr>
                <th>Index</th>
                <th></th>
                <th>Description</th>
                <th>Category</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>#</td>
                <td><img src="img/CLIM-ECOSOLAR.png" alt="product" width="100px"></td>
                <td>Category 1</td>
                <td>Ante turpis integer aliquet porttitor.</td>
                <td>29.99</td>
                <td>13</td>
                <td><p><a href="#">supprimer</a></p> <p><a href="#">modifier</a></p></td>
            </tr>
            <c:forEach items="${products}" var="product" varStatus="index">
                <tr>
                    <td><c:out value="${index.count}"/></td>
                    <td><img src="img/${product.image}" alt="product ${index.count}" width="100px"></td>
                    <td><c:out value="${product.category}"/></td>
                    <td><c:out value="${product.description}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><c:out value="${product.quantity}"/></td>
                    <td><p><a href="#">supprimer</a></p> <p><a href="#">modifier</a></p></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="3"></td>
                <td>--- end ---</td>
                <td colspan="2"></td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>

<%@include file="assets/scripts.jsp"%>
</body>
</html>
