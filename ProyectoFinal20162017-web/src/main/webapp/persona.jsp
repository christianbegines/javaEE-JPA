<%-- 
    Document   : añadirPersona
    Created on : 21-feb-2017, 19:20:59
    Author     : chavo
--%>

<%@page import="com.fpmislata.domain.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <%
    
        Categoria c =(Categoria)request.getAttribute("categoria"); 
    
        if(c!=null){
        
    %>   
    <head>
        <title>Modificar categoria</title>
    </head>
    <body>   
        <h1>Modificar categoria </h1>
        <form action="UpdateCategoria?accion=modificar&id=<%=c.getId()%>" method="post">      
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block;" value="<%=c.getNombre()%>" > 
            <br>
            <input type="submit" value="Enviar" />
        </form>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
    <%}else{%>
     <head>
        <title>Agregar categoria</title>
    </head>
    <body>    
        <h1>Agregar categoria</h1>
        <form action="AddCategoria" method="post">      
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block;" > 
            <br>
            <input type="submit" value="Enviar" />
        </form>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
    <% } %>
</html>
