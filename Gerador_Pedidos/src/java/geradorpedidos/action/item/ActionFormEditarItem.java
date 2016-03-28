package geradorpedidos.action.item;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import geradorpedidos.action.Action;
import geradorpedidos.dao.ItemDAO;
import geradorpedidos.model.Item;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionFormEditarItem implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String strId = request.getParameter("iditem");
        Item item = new Item();

        if (strId != null) {
            int id = Integer.parseInt(strId);
            ItemDAO dao = new ItemDAO();
            item = dao.getItensById(id);
        }
        request.setAttribute("item", item);
        return "/WEB-INF/jsp/adicionarItens.jsp";
    }

}
