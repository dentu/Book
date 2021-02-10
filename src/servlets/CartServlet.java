package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import po.Cart;
import po.User;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User loginuser = (User) req.getSession().getAttribute("loginuser");
		CartDAO dao = new CartDAO();
		try {
			List<Cart> list = dao.findByUser(loginuser.getId());
			double money = 0;
			for (Cart cart : list) {// 循环得到使用价格
				money += cart.getSubtotal();// 价格相加得到总价格
			}
			req.setAttribute("carts", list);
			req.setAttribute("total", money);
			req.getRequestDispatcher("/cart.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
