<%--<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario-Alta</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>Alta Usuario</h1>
            <s:form action="altaUsuario" method="post">
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <s:textfield name="dni" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <s:textfield name="nombre" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="apellidos">Apellidos</label>
                    <s:textfield name="apellidos" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="fechaNacimiento">Fecha de Nacimiento</label>
                    <s:textfield name="fechaNacimiento" type="date" class="form-control" />
                </div>
                <div class="form-group">
                    <label>Rol</label>
                    <s:select name="idRol" 
                              list="roles" 
                              listKey="id" 
                              listValue="tipo" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona un rol"/>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña</label>
                    <s:password name="password" class="form-control" />
                </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
            </s:form>
        </div> 
    </body>
</html>
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario-Alta</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>Alta Usuario</h1>
            <s:form action="altaUsuario" method="post">
                <s:hidden name="operacion" value="alta" />
                <div class="form-group">
                    <s:label for="dni" value="DNI" />
                    <s:textfield name="dni" id="dni" class="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="nombre" value="Nombre" />
                    <s:textfield name="nombre" id="nombre" class="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="apellidos" value="Apellidos" />
                    <s:textfield name="apellidos" id="apellidos" class="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="fechaNacimiento" value="Fecha de Nacimiento" />
                    <s:textfield name="fechaNacimiento" id="fechaNacimiento" type="date" class="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="idRol" value="Rol" />
                    <s:select name="idRol" list="roles" listKey="id" listValue="tipo" class="form-control" headerKey="" headerValue="Selecciona un rol"/>
                </div>
                <div class="form-group">
                    <s:label for="password" value="Contraseña" />
                    <s:password name="password" id="password" class="form-control" />
                </div>
                    <s:submit cssClass="btn btn-primary" value="Guardar"/>
            </s:form>
        </div> 
    </body>
</html>
