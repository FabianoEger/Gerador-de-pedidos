/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ClienteDAO;
import geradorpedidos.model.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabiano.eger
 */
public class ActionCriarCliente implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(request.getParameter("nomecliente"));
        cliente.setEmail(request.getParameter("email"));

        ClienteDAO dao = new ClienteDAO();

        if (!"0".equals(request.getParameter("id"))) {
            int id = Integer.parseInt(request.getParameter("id"));
            cliente.setIdCliente(id);
            dao.atualizar(cliente);

            request.setAttribute("cliente", "alterado"); 

        } else {
            dao.inserir(cliente);
            request.setAttribute("cliente", "criado");
        }

        return "controller?action=ActionListarCliente"; // aqui pode dar erro, SE DER ERRO, coloque:
                                                         //   geradorpedido.action?action=ActionListarCliente
                                                        // e faca o mesmo com as outras actions
    }

}
