package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import po.Cart;
import po.User;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		// 检查是否登录
		User loginuser = (User) req.getSession().getAttribute("loginuser");
		if (loginuser == null) {
			req.setAttribute("msg", "<script>alert('还没有登录,请先登录!!')</script>");
			req.getRequestDispatcher("/info?id=" + id).forward(req, resp);
			return;
		}
		CartDAO dao = new CartDAO();// 创建CartDAO对象
		try {
			// 如果添加的书存在，就数量加一
			if (dao.findBypid(loginuser.getId(), id) != null) {
				dao.buyuum(1, loginuser.getId(), id);// 数量加一
				req.getRequestDispatcher("/cart").forward(req, resp);
				return;
			}
			Cart cart = new Cart(loginuser.getId(), id, 1);
			dao.save(cart);
			req.getRequestDispatcher("/cart").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
