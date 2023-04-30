<%--
  Created by IntelliJ IDEA.
  User: jugem
  Date: 7/03/2023
  Time: 9:51 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style/products.css">
    <title>Productos</title>
</head>
<body>
<%
    String errors="";
    String products="";
    if(request.getSession().getAttribute("errors")!=null){
        errors = request.getSession().getAttribute("errors").toString();

    }
    if(request.getSession().getAttribute("products")!=null){
        products = request.getSession().getAttribute("products").toString();
        System.out.println("JSP PRODUCTS:"+ products);
    }
%>
    <input type="hidden" id="errors" value=<%=errors%>>
    <input type="hidden" id="products" value=<%=products%>>

    <nav>

        <img src="images/logo.png" alt="logo">

        <div class="nav__links">


            <a href="products.jsp">PRODUCTOS</a>

            <a href="admin-employees.jsp">EMPLEADOS</a>


        </div>

    </nav>
    <main>
        <h1>GESTIÓN PRODUCTOS</h1>
        <form action="/products" method="post" class="main__form">
            <h1>Agregar producto</h1>


            <div class="inputs__container" >

                <div class="input__item" id="name">

                    <p>Nombre</p>
                    <input type="text" name="name" value="${param.name}">

                </div>

                <div class="input__item" id="avaibleAmount">

                    <p>Cantidad disponible</p>
                    <input type="number" name="avaibleAmount">

                </div>

                <div class="input__item" id="urlImage">

                    <p>URL Imagen</p>
                    <input type="text" name="urlImage">

                </div>

                <div class="input__item" id="status">

                    <p>Disponibilidad</p>
                    <label>
                        Disponible <input type="radio" name="status" value="true">
                    </label>
                    <label>
                        No disponible <input type="radio" name="status" value="false">
                    </label>


                </div>

                <div class="input__item" id="price">

                    <p>Precio</p>
                    <input type="number" name="price">

                </div>


            </div>
            <button value="Agregar" type="submit" class="form__button" >AGREGAR</button>
        </form>

            <h2 class="header">Productos</h2>

            <table id="table-products">
                <thead>
                <tr>
                    <th>Imagen</th>
                    <th>Nombre</th>
                    <th>Cantidad disponible</th>
                    <th>Estado</th>
                    <th>Precio</th>
                    <th>Acciones</th>

                </tr>
                </thead>
                <tbody id="table-body">


                </tbody>
            </table>
    </main>
    <script src="frontend/products.js"  type="text/javascript"></script>
</body>
</html>
