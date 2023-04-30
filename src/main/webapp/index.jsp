<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar Sesión</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <link rel="stylesheet" href="style/login.css">
    </head>
    <body>
        <input type="hidden" id="status" value="<%=request.getSession().getAttribute("status") %>">
        <input type="hidden" id="error" value="<%=request.getSession().getAttribute("error") %>">



        <div class="container__form flex__column" >

            <img src="images/logo.png" alt="logo">

            <form method="post" action="/login-authentication" class="form flex__column">
                <h1>INICIA SESIÓN</h1>

                <input type="text" name="username" placeholder="Usuario" class="form__input">
                <input type="password" name="password" class="form__input" placeholder="Contraseña">

                <button type="submit">INICIAR SESIÓN</button>

            </form>

        </div>
        <script src="frontend/login.js" type="module"></script>

    </body>
</html>