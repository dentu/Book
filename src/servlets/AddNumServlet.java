package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Cart;
import po.Product;
import po.User;
import dao.CartDAO;
import dao.ProductDAO;

//添加书的数量
@WebServlet("/addnum")
public class AddNumServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String no = req.getParameter("no");
		// 执行增加数量的操作
		CartDAO dao = new CartDAO();
		ProductDAO pd = new ProductDAO();
		try {
			User loginuser = (User) req.getSession().getAttribute("loginuser");
			Product p = pd.findById(no);
			Cart cart = dao.findBypid(loginuser.getId(), no);

			if (cart.getBuynum() >= p.getPnum()) {// 如果购买书的数量等于库存，不增加
				req.getRequestDispatcher("/cart").forward(req, resp);
				return;
			}
			dao.addNum(1, loginuser.getId(), no);
			req.getRequestDispatcher("/cart").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
