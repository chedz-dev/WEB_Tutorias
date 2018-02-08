
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap-3.3.7-dist/css/signin.css" rel="stylesheet">
        <link href="resources/stylesheet.css" rel="stylesheet">
        <script src="resources/bootstrap-3.3.7-dist/css/ie-emulation-modes-warning.js"></script>
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
                    <li><a href="/Tutorias/Materia?action=QRY">Materias</a></li>
                    <li class="active"><a href="/Tutorias/Profesor?action=QRY">Profesores</a></li>
                    <li><a href="#">Tutorias</a></li>
                  </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/Tutorias/Login?action=logout"><span class="glyphicon glyphicon-log-in"></span> Cerrar sesión</a></li>
                      </ul>
                </div>  
            </nav>
        </div>
        <div class="container roundedborder1 color1">
            <table class='table table-dark table-condensed'>
                <thead>
                  <tr>
                    <th>Nombre</th>
                    <th>Usuario</th>
                    <th>Correo</th>
                    <th>Instituto</th>
                    <th colspan="3"></th>
                  </tr>
                </thead>

                <tbody>
                <c:forEach items="${profesores}" var="profesores">
                    <tr>
                        <td><c:out value="${profesores.nombre}"/></td>
                        <td><c:out value="${profesores.usuario}"/></td>
                        <td><c:out value="${profesores.correo}"/></td>
                        <td><c:out value="${profesores.instituto}"/></td>
                        <c:if test="${sessionScope.role=='admin'}">
                        <td><a href="/Tutorias/Profesor?action=DEL&id=${profesores.id}">Borrar</a></td>
                        <td><a href="/Tutorias/Profesor?action=UPD_RED&id=${profesores.id}">Editar</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${sessionScope.role=='admin'}">
            <a href="/Tutorias/Profesor?action=INS_RED">Agregar profesor</a>
            </c:if>
        </div>
    <script src="resources/bootstrap-3.3.7-dist/css/jquery.min.js"></script>    
    </body>
</html>
