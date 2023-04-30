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
    <link rel="stylesheet" type="text/css" href="style/employee.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <title>Empleados</title>
</head>


<body>
<% String employees = "";
    if(request.getSession().getAttribute("employees")!=null){
        employees = request.getSession().getAttribute("employees").toString();
    }
%>
<input id="employees" type="hidden" value=<%=employees%>>
<input id="registerError" type="hidden" value="<%=request.getSession().getAttribute("registerError")%>">
<nav>

    <img src="images/logo.png" alt="logo">

    <div class="nav__links">

        <a href="products.jsp">PRODUCTOS</a>

        <a href="admin-employees.jsp">EMPLEADOS</a>


    </div>

</nav>
<main>
    <h1>GESTIÓN EMPLEADOS</h1>
    <form action="/admin-employees" method="post" class="main__form">
        <h1>Agregar empleado</h1>


        <div class="inputs__container" >

            <div class="input__item" id="name">

                <p>Nombre</p>
                <input type="text" name="name">

            </div>

            <div class="input__item" id="avaibleAmount">

                <p>No. identificación</p>
                <input type="text" name="id">

            </div>

            <div class="input__item" id="urlImage">

                <p>Correo electronico</p>
                <input type="text" name="email">

            </div>

        </div>
        <button value="Agregar" type="submit" class="form__button" >AGREGAR</button>
    </form>
    <h2 class="header">Empleados</h2>

    <table id="table-products">
        <thead>
        <tr>
            <th>Imagen</th>
            <th>Nombre</th>
            <th>No. Identificación</th>
            <th>Correo elecronico</th>
            <th>Productos vendidos</th>
            <th>Acciones</th>


        </tr>
        </thead>
        <tbody id="table-body">


        </tbody>
    </table>
</main>
<script src="frontend/admin-emplooyes.js" type="text/javascript"></script>
</body>
</html>
