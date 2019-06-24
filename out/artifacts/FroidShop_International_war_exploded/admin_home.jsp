<%--
  Created by IntelliJ IDEA.
  User: nanac
  Date: 3/12/2019
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - FroidShop International</title>
    <link rel="stylesheet" href="assets/css/main.css"/>
</head>
<body>

<%@include file="assets/menu_admin.jsp" %>

<div align="center" style="margin-top: 100px;">
    <h4>Welcome <%= request.getAttribute("username")%></h4>
</div>

<form action="adminHome" method="post">
    <div class="container">
        <div class="row">
            <div class="box">
                <h4> Choose the site's devise</h4>
                <label for="devise">Devise</label>
                <select id="devise" name="devise">
                    <optgroup label="Devise...">
                        <option>$</option>
                        <option>DTN</option>
                        <option>Euros</option>
                        <option>Francs</option>
                    </optgroup>
                </select>
                <br>
                <input type="submit">
            </div>
        </div>
    </div>
</form>

<%@include file="assets/scripts.jsp" %>

</body>
</html>
