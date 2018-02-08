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
        <title>Update Alumno</title>
    </head>
    <body>
        <h1>Información detallada del Alumno</h1>
        <div class="container-fluid roundedborder2">
            <form action = "/Tutorias/Alumno" method = "POST">
                <h3><b>ID:</b> ${alumno.id}</h3>
                <br/>
                <h3><b>Matricula:</b> ${alumno.matricula}</h3>
                <br />
                <h3><b>Nombre:</b> ${alumno.nombre}</h3>
                <br />
                <h3><b>Apellidos:</b> ${alumno.apellidos}</h3>
                <br />
                <h3><b>Foto:</b> ${alumno.foto}</h3>
                <br />
                <h3><b>Correo:</b> ${alumno.correo}</h3>
                <br />
                <h3><b>Tutor: </b>Ninguno</h3>
                <br />
                <a href="#">Agregar tutor</a>
                <br/>
                <h3><b>Materias no asignadas</b></h3>
                <br />
                <table class='table table-dark table-condensed'>
                <thead>
                    <tr>
                      <th>Materia</th>
                      <th>P1</th>
                      <th>P2</th>
                      <th>P3</th>
                      <th>Final</th>
                      <th>Ex1</th>
                      <th>Ex2</th>
                      <th>Es</th>
                      <th colspan="3"></th>
                    </tr>
                  </thead>

                  <tbody>
                  
                  </tbody>
                </table>
                <input class="form-control btn btn-danger" type = "submit" value = "Atras" />
                <input type="hidden" name="action" value="QRY"/>
            </form>
                <br/>
        </div>
    </body>
</html>
