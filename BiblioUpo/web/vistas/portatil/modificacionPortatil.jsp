<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Portatil - <s:property value="portatil.marca" /> <s:property value="portatil.modelo" /></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>webwing</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
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
    </head>
    <body>
        <h1>Modificar Portatil - <s:property value="portatil.marca" /> <s:property value="portatil.modelo" /></h1>
        <div class="container">
            <s:form action="modificacionPortatil" method="post">
                <s:hidden name="numSerie" value="%{portatil.numSerie}" />
                <s:textfield label="Número de Serie" name="numSerie" value="%{portatil.numSerie}" />
                <s:textfield label="Marca" name="marca" value="%{portatil.marca}" />
                <s:textfield label="Modelo" name="modelo" value="%{portatil.modelo}" />
                <div class="form-group">
                    <s:label for="idSistemaOperativo" value="Sistema Operativo" />
                    <s:select name="idSistemaOperativo" list="sistemasOperativos" listKey="id" listValue="nombre" value="%{portatil.sistemaOperativo.id}" cssClass="form-control" headerKey="" headerValue="Selecciona un Sistema Operativo"/>
                </div>
                <div class="form-group">
                    <s:label for="disponible" value="Disponible" />
                    <s:radio name="disponible" list="#{'true':'Sí', 'false':'No'}" value="%{portatil.recurso.disponible}"  />
                </div>
                <s:submit value="Guardar" />
            </s:form>
        </div>
    </body>
</html>
