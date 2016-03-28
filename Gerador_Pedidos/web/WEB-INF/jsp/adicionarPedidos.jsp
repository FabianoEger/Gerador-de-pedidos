<%-- 
    Document   : cadastrarClientes
    Created on : 15/03/2016, 21:37:52
    Author     : fabiano.eger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="agenda" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Cadastrar pedido</title>
    <link href="css/jquery-ui.css" rel="stylesheet"> 
    
    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
  </head>
  <body>
    <h1>Adiciona pedidos</h1>
    <hr/>
    <form action="controller?action=ActionCriarPedido" method="POST">
        Id pedido:<input type="text" name="id" value="${pedido.idpedido}"><br>
        Cliente:<input type="text" name="id" value="${pedido.idCliente}"><br>
    	Valor pedido <input type="text" name="valorPedido" value="${pedido.valorPedido}"><br>
        Data pedido: <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="formattedDate"/>
    	Data de Nascimento: <pedido:campoData id="dataPedido" value="${formattedDate}"></pedido:campoData><br>
    	<c:if test="${ pedido.id != 0 }">
   
    	<c:if test="${ pedido.idPedido != 0 }">
    		<input type="hidden" name="id" value="${pedido.idPedido}">
    	</c:if>
    	<input type="submit" value="Gravar">
    </form>
  </body>
</html>