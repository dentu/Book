package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Order;
import dao.OrderDAO;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		OrderDAO od = new OrderDAO();
		try {
			Order o = od.findByid(id);
			req.setAttribute("o", o);// 把购买的订单号，价格等信息传到pay.jsp
			req.getRequestDispatcher("pay.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
