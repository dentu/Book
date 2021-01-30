package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Cart;
import po.User;
import dao.CartDAO;

@WebServlet("/reducenum")
public class ReduceNumServlet 	extends HttpServlet {

		public void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String no=req.getParameter("no");
			//执行增加数量的操作
			CartDAO dao=new CartDAO();
			try {
				User loginuser=(User)req.getSession().getAttribute("loginuser");
				Cart cart=dao.findBypid(loginuser.getId(), no);
				if(cart.getBuynum()<=1){//购买的书不能小于一
					req.getRequestDispatcher("/cart").forward(req, resp);
					return;
				}
				dao.addNum(-1, loginuser.getId(), no);
				req.getRequestDispatcher("/cart").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
