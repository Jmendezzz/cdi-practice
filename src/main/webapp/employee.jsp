<%--
  Created by IntelliJ IDEA.
  User: jugem
  Date: 6/03/2023
  Time: 10:20 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style/employee-main-page.css">
    <title>Empleados</title>
</head>
<body>
    <%
        String products="";
        if(request.getSession().getAttribute("products")!=null){
            products = request.getSession().getAttribute("products").toString();
        }%>
    <nav>

        <input type="hidden" id="products" value=<%=products%>>

        <img alt="logo" src="images/logo.png">

    </nav>
    <main>
        <h1>Bienvenido, <%=request.getSession().getAttribute("employeeName")%></h1>

        <h2>Realiza una venta</h2>
        <form action="/employee" method="post" class="main__form">

            <div class="items__container">
                <div class="flex__column">
                    <div id="previsualizacion__container" class="flex__column">


                    </div>
                    <span id="total">0</span>
                    <input type="hidden" name="data-sale" id="data-sale-input">
                    <button type="submit" id="confirm-sale-button" class="form__button">Confirmar</button>

                </div>
                <div id="productos__container">

                </div>

            </div>

        </form>

    </main>

<script src="frontend/employee.js" type="text/javascript"></script>
</body>
</html>
