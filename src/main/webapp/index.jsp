<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/bootstrap-3.3.7-dist/css/signin.css" rel="stylesheet">
    <script src="resources/bootstrap-3.3.7-dist/css/ie-emulation-modes-warning.js"></script>
    <link href="resources/stylesheet.css" rel="stylesheet">
    <title>Tutorias</title>
  </head>

  <body>

    <div id="generator" class="container">

        <form class="form-signin" action="/Tutorias/Login" method="post">
            
            <h2 class="form-signin-heading">Sistema de Tutorias</h2>
            <div class="alert-danger">${logerror}</div><br>
            <input type="text" id="inputEmail" class="form-control" placeholder="Usuario" name="user" required autofocus>
            <input type="hidden" name="action" value="login"/>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Recordar cuenta
                </label>
            </div>
         
            <button id="signin" class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
        </form>
        <script>

        </script>
    </div>
    <script src="resources/bootstrap-3.3.7-dist/css/jquery.min.js"></script>
  </body>
</html>
