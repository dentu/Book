package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Product;
import dao.ProductDAO;

@WebServlet("/info")
public class InfoServlet  extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		try {
			ProductDAO dao=new ProductDAO();
			Product p=dao.findById(id);
			req.setAttribute("p", p);
			req.getRequestDispatcher("/info.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
