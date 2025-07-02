<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <!-- fevicon -->
        <link rel="icon" href="images/upo2.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
           <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
           <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
        <title>Usuario: <s:property value="usuario.correo" /></title>
    </head>
    <body>
        <h1>Usuario: <s:property value="usuario.correo" /></h1>
        <div class="container">
            <h2>DNI</h2>
            <p><s:property value="usuario.dni" /></p>
            <h2>Nombre</h2>
            <p><s:property value="usuario.nombre" /></p>
            <h2>Apellidos</h2>
            <p><s:property value="usuario.apellidos" /></p>
            <h2>Correo</h2>
            <p><s:property value="usuario.correo" /></p>
            <h2>Fecha de Nacimiento</h2>
            <p><s:property value="usuario.fechaNacimiento" /></p>
        </div>

        <div class="container">
            <h1>Reservas</h1>
            <s:if test="usuario.reservas == null">
                <p>No hay reservas para <s:property value="usuario.nombre" /></p>
            </s:if>
            <s:else>
                <table border="1">
                    <thead>
                    <th>ID</th>
                    <th>Recurso</th>
                    <th>Fecha</th>
                    <th>Duracion (horas)</th>
                    <th>Entregado</th>
                    </thead>
                    <tbody>
                        <s:iterator value="usuario.reservas">
                            <tr>
                                <td><s:property value="id" /></td>
                                <td><s:property value="recurso.id" /></td>
                                <td><s:property value="fecha" /></td>
                                <td><s:property value="duracionHoras" /></td>
                                <td><s:property value="entregado" /></td>
                                <td>
                                    <s:form action="consultaReserva" method="post">
                                        <s:hidden name="idReserva" value="%{id}" />
                                        <s:submit value="Consultar" />
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:else>
        </div>

        <div class="container">
            <h1>Refuerzos</h1>
            <s:if test="usuario.refuerzos == null">
                <p>No hay refuerzos para <s:property value="usuario.nombre" /></p>
            </s:if>
            <s:else>
                <table border="1">
                    <thead>
                    <th>ID</th>
                    <th>Recurso</th>
                    <th>Sala</th>
                    <th>Descripción</th>
                    <th>Asignatura</th>
                    <th>Tipo</th>
                    </thead>
                    <tbody>
                        <s:iterator value="usuario.refuerzos">
                            <tr>
                                <td><s:property value="id" /></td>
                                <td><s:property value="recurso.id" /></td>
                                <td><s:property value="sala.nombre" /></td>
                                <td><s:property value="descripcion" /></td>
                                <td><s:property value="asignatura" /></td>
                                <td><s:property value="tipo" /></td>
                                <td>
                                    <s:form action="consultaRefuerzo" method="post">
                                        <s:hidden name="idRefuerzo" value="%{id}" />
                                        <s:submit value="Consultar" />
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:else>
        </div>
    </body>
</html>
