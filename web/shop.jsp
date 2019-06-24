<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 3/27/2019
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Shop - FroidShop International</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
<%@include file="assets/menu.jsp" %>
<!-- Banner -->
<section id="banner" class="bg-img" data-bg="banner.jpg">
    <div class="inner">
        <header>
            <h1>FroidShop International</h1>
        </header>
    </div>
    <a href="#" class="more">Learn More</a>
</section>

<!--Section Shop-->
<div class="container">
    <div class="row">
        <form method="post" action="shop">
        <c:forEach items="${list}" var="product" varStatus="index">

            <div class="box">
                <span class="image left"><img src="img/${product.image}" alt="product ${index.count}" width="120px"></span>
                <h2>${product.description}</h2>
                <h4>Prix : ${product.price} <%= request.getAttribute("monaie")%></h4>

                    <input type="hidden" value="${product.id}" name="productIdentity">
                    <input type="submit" value="Ajouter au Panier">
            </div>

        </c:forEach>
        </form>
    </div>
</div>

<!-- Footer -->
<footer id="footer">
    <div class="inner">

        <h2>Contact</h2>

        <form action="#" method="post">

            <div class="field half first">
                <label for="name">Name</label>
                <input name="name" id="name" type="text" placeholder="Name">
            </div>
            <div class="field half">
                <label for="email">Email</label>
                <input name="email" id="email" type="email" placeholder="Email">
            </div>
            <div class="field">
                <label for="message">Message</label>
                <textarea name="message" id="message" rows="6" placeholder="Message"></textarea>
            </div>
            <ul class="actions">
                <li><input value="Send Message" class="button alt" type="submit"></li>
            </ul>
        </form>

        <ul class="icons">
            <li><a href="#" class="icon round fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon round fa-facebook"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon round fa-instagram"><span class="label">Instagram</span></a></li>
        </ul>

        <a href="admin">Welcome Admin</a>

        <div class="copyright">
            &copy; Copyright: <a href="shop">FroidShop</a> International.
        </div>

    </div>
</footer>

<%@include file="assets/scripts.jsp" %>
</body>
</html>
