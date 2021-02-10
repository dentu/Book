package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.OrderItem;
import dao.OrderDAO;
import dao.ProductDAO;

@WebServlet("/ok")
public class OkServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		OrderDAO od = new OrderDAO();
		ProductDAO pd = new ProductDAO();
		try {
			od.payzt(id);
			List<OrderItem> oi = od.findItem(id);
			for (OrderItem orderItem : oi) {// 循环减去库存
				pd.jian(orderItem.getBuynum(), orderItem.getProductid());
			}
			req.getRequestDispatcher("payok.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
