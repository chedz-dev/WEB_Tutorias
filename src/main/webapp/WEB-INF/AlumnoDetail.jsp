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
        <title>Update Alumno</title>
    </head>
    <body>
        <h1>Información detallada del Alumno</h1>
        <div class="container-fluid roundedborder2">
            <form action = "/Tutorias/Alumno" method = "POST">
                <h3><b>ID:</b> ${alumno.id}</h3>
                <input type="hidden" name="id" value="${alumno.id}"/>
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
                <h3><b>Tutor: </b>${tutor}</h3>
                <input type="hidden" name="entrevistador" value="${tutor}"/>
                <br />
                <c:if test="${sessionScope.role=='admin'}">
                <select id="tutor-dropdown" name="dropdown">
                <c:forEach items="${profesores}" var="profesores">
                        <option value="${profesores.id}">${profesores.nombre}</option>
                </c:forEach>
                </select>
                <input id="alumno_id" type="hidden" value="${alumno.id}"/>
                <a id="updtutorhref" href="/Tutorias/AlumnoDetail?action=UPD_TUTOR&id_alumno=${alumno.id}&id_tutor=${profesores[0].id}">Asignar tutor</a>
                </c:if>
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
                
                <c:if test="${sessionScope.role=='profesor'}">
                    <a href='/Tutorias/Entrevista?action=INS_RED&id=${alumno.id}&entrevistador="${tutor}"'>Realizar entrevista</a>
                    <input type="hidden" name="action" value="PROF_QRY"/>
                </c:if>
                <c:if test="${sessionScope.role=='admin'||sessionScope.role=='staff'}"><input type="hidden" name="action" value="QRY"/></c:if>
                <input class="form-control btn btn-danger" type = "submit" value = "Atras" />
                
            </form>
                <br/>
        </div>
        <script src="resources/script.js"></script>
    </body>
</html>
