package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import po.Order;
import po.User;

@WebServlet("/orderinfo")
public class OrderInfo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User loginuser = (User) req.getSession().getAttribute("loginuser");
		OrderDAO od = new OrderDAO();
		try {
			List<Order> orders = od.findOrder(loginuser.getId());
			req.setAttribute("orders", orders);
			req.getRequestDispatcher("/orderInfo.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
