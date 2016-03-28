/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action.pedido;

import geradorpedidos.action.Action;
import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.model.Pedido;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabiano.eger
 */
public class ActionCriarPedido implements Action {
    
    @Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Pedido pedido = new Pedido();
		int idPedido = Integer.parseInt(request.getParameter("idpedido"));
                int idCliente = Integer.parseInt(request.getParameter("idcliente"));
                double valorPedido = Double.parseDouble(request.getParameter("valorPedido"));
		
		Calendar dataPedido = null;
		
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataPedido"));
			dataPedido = Calendar.getInstance();
			dataPedido.setTime(data);
		} catch (ParseException e) {
			throw new RuntimeException("Erro de conversao da data.", e);
		}
		
		pedido.setDataPedido(dataPedido);
		
		PedidoDAO daopedido = new PedidoDAO();
		
		
		if (request.getParameter("idpedido") != "") {
			int id = Integer.parseInt(request.getParameter("idpedido"));
			pedido.setIdPedido(idPedido);
			daopedido.atualizar(pedido);
               
			
			request.setAttribute("mensagem", "Pedido alterado com sucesso.");
			
		} else {
			daopedido.inserir(pedido);
			request.setAttribute("mensagem", "Pedido criado com sucesso");
		}
		
		return "controller?action=ActionListarPedidos";
	}

 
    
}
