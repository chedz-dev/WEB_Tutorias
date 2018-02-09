
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
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
    
    <body>
        <h1>Bienvenido profesor ${profesor[1]}!</h1><br>
        <div class="container">Rol: ${sessionScope.role}</div>
        <div class="collapse navbar-collapse">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                  <ul class="nav navbar-nav">
                    <li class="active"><a href="/Tutorias/Alumno?action=PROF_QRY">Tutorados</a></li>

                  </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/Tutorias/Login?action=logout"><span class="glyphicon glyphicon-log-in"></span> Cerrar sesión</a></li>
                      </ul>
                </div>  
            </nav>
        </div>
        <div class="container roundedborder1 color1" >
            <table class='table table-dark table-condensed implementsWrapper' width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>Matricula</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Foto</th>
                    <th>Correo</th>
                    <c:if test="${sessionScope.role=='admin'}">
                    <th></th>
                    <th></th>
                    </c:if>
                  </tr>
                </thead>

                <tbody>
                <c:forEach items="${alumnos}" var="alumnos">
                    <tr>
                        <td><a href="/Tutorias/AlumnoDetail?action=QRY&id=<c:out value="${alumnos.id}"/>">${alumnos.matricula}</a></td>
                        <td><c:out value="${alumnos.nombre}"/></td>
                        <td><c:out value="${alumnos.apellidos}"/></td>
                        <td><c:out value="${alumnos.foto}"/></td>
                        <td><c:out value="${alumnos.correo}"/></td>
                        <c:if test="${sessionScope.role=='admin'}">
                        <td><a href="/Tutorias/Alumno?action=DEL&id=${alumnos.id}">Borrar</a></td>
                        <td><a href="/Tutorias/Alumno?action=UPD_RED&id=${alumnos.id}">Editar</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${sessionScope.role=='admin'}">
            <a href="/Tutorias/Alumno?action=INS_RED">Agregar alumno</a>
            </c:if>
        </div> 
    <script src="resources/script.js"></script>
    </body>
</html>
