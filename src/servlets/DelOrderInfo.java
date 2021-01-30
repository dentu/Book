package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;

@WebServlet("/delorderinfo")
public class DelOrderInfo extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String no=req.getParameter("id");
		try {
			OrderDAO dao=new OrderDAO();
			dao.delorder(no);
			req.getRequestDispatcher("/orderinfo").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
