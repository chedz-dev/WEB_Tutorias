<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap-3.3.7-dist/css/signin.css" rel="stylesheet">
        <script src="resources/bootstrap-3.3.7-dist/css/ie-emulation-modes-warning.js"></script>
        <link href="resources/stylesheet.css" rel="stylesheet">
        <title>Update Materia</title>
    </head>
    <body>
        <h1>Actualizar información de la Materia</h1>
        <div class="container-fluid roundedborder2">
            <form action = "/Tutorias/Materia" method = "POST">
                ID: <input class="form-control" type="text" name="id" value="${materia.id}" readonly/>
                <br/>
                Nombre: <input required class="form-control" type = "text" name = "nombre" value="${materia.nombre}"/>
                <br />  
                <input class="form-control btn btn-danger" type = "submit" value = "Actualizar" />
                <input type="hidden" name="action" value="UPD"/>
            </form>
                <br/>
            <form action = "/Tutorias/Materia" method = "POST">
                <input class="form-control btn btn-danger" type = "submit" value = "Cancelar" />
                <input type="hidden" name="action" value="QRY"/>
            </form>
        </div>
    </body>
</html>
