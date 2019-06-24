<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 4/2/2019
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Panier - FroidShop International</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
<%@include file="assets/menu.jsp" %>

<form method="post" action="cart">
    <div class="container">
        <div class="6u 12u$(medium)">
            <c:forEach items="${cartList}" var="product" varStatus="index">
                <div class="box">
                    <span class="image left"><img src="img/${product.image}" alt="product ${index.count}" width="120px"></span>
                    <h2>${product.description}</h2>
                    <div class="article-body">
                        <p>Price : ${product.price} <%= request.getAttribute("monaie")%></p>
                    </div>
                    <span class="left">
                        <p><a href="#"></a> </p>
                    </span>
                </div>
            </c:forEach>
        </div>
        <h4>Prix total: 5689.65 $ - <span style="color: cadetblue">1 article</span></h4>
        <br>
        <div><input type="submit" value="Valider"></div>
    </div>
</form>

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
