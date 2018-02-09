
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <script src="resources/bootstrap-3.3.7-dist/css/ie-emulation-modes-warning.js"></script>
        <script src="resources/bootstrap-3.3.7-dist/css/jquery.min.js"></script>
        <script src="resources/DataTables/DataTables-1.10.16/js/jquery.dataTables.min.js"></script>
        <script src="resources/DataTables/DataTables-1.10.16/js/dataTables.bootstrap.min.js"></script>
        <script src="resources/DataTables/DataTables-1.10.16/js/jquery.dataTables.min.js"></script>
        <script src="resources/DataTables/DataTables-1.10.16/js/dataTables.bootstrap.min.js"></script>
        
        <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap-3.3.7-dist/css/signin.css" rel="stylesheet">
        <link href="resources/DataTables/DataTables-1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">
        
        <link href="resources/stylesheet.css" rel="stylesheet"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Bienvenido ${sessionScope.name}!</h1><br>
        <div class="container">Rol: ${sessionScope.role}</div>
        
        <div class="collapse navbar-collapse">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                  <ul class="nav navbar-nav">
                    <li><a href="/Tutorias/Alumno?action=QRY">Estudiantes</a></li>
                    <li class="active"><a href="/Tutorias/Materia?action=QRY">Materias</a></li>
                    <li><a href="/Tutorias/Profesor?action=QRY">Profesores</a></li>
                    <li><a href="#">Entrevistas</a></li>
                  </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/Tutorias/Login?action=logout"><span class="glyphicon glyphicon-log-in"></span> Cerrar sesión</a></li>
                      </ul>
                </div>  
            </nav>
        </div>
        <div class="container roundedborder1 color1">
            <table class='table table-dark table-condensed implementsWrapper' width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <c:if test="${sessionScope.role=='admin'}"><th></th><th></th></c:if>
                  </tr>
                </thead>

                <tbody>
                <c:forEach items="${materias}" var="materias">
                    <tr>
                        <td><c:out value="${materias.id}"/></td>
                        <td><c:out value="${materias.nombre}"/></td>
                        <c:if test="${sessionScope.role=='admin'}">
                        <td><a href="/Tutorias/Materia?action=DEL&id=${materias.id}">Borrar</a></td>
                        <td><a href="/Tutorias/Materia?action=UPD_RED&id=${materias.id}">Editar</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${sessionScope.role=='admin'}">
            <a href="/Tutorias/Materia?action=INS_RED">Agregar materia</a>
            </c:if>
        </div>
    <script src="resources/script.js"></script> 
    </body>
</html>
