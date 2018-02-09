
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
        <title>Insert Alumno</title>
    </head>
    <body>
        <h1>Realizar nueva entrevista</h1>
        <div class="container-fluid roundedborder2">
            <form id="usrform" action = "/Tutorias/Entrevista" method = "POST">
                <input type = "hidden" name = "id_alumno" value="${alumno.id}">
                Matricula: <input required class="form-control" type = "text" name = "matricula" value="${alumno.matricula}">
                <br />
                Alumno: <input required class="form-control" type = "text" name = "nombre" value="${alumno.nombre}"/>
                <br />
                Entrevistador: <input required class="form-control" type = "text" name = "correo" value=${entrevistador}/>
                <br />
                Notas:
                <br/>
                <textarea rows="4" cols="50" name="notas" form="usrform"></textarea>
                <br/><br/>
                <input class="form-control btn btn-danger" type = "submit" value = "Registrar entrevista" />
                <input type="hidden" name="action" value="INS"/>
             </form>
            <br/>
             <form action = "/Tutorias/Alumno" method = "POST">
                 <input class="form-control btn btn-danger" type = "submit" value = "Cancelar" />
                <input type="hidden" name="action" value="PROF_QRY"/>
             </form>
        </div>
    </body>
</html>
