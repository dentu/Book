package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Cart;
import po.User;
import dao.CartDAO;

@WebServlet("/order")
public class OrderServlet 	extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User loginuser=(User)req.getSession().getAttribute("loginuser");
		CartDAO dao=new CartDAO();
		try {
			List<Cart> list=dao.findByUser(loginuser.getId());
			double money=0;
			for(Cart c:list){
				money+=c.getSubtotal();
			}
			req.setAttribute("carts", list);
			req.setAttribute("money", money);
			req.getRequestDispatcher("/order.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
