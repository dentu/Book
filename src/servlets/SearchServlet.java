package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Product;
import dao.ProductDAO;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("ss");
		if ("".equals(name) || name.equals(null)) {
			req.setAttribute("msg", "<script>alert('搜索不能为空')</script>");
			req.getRequestDispatcher("list").forward(req, resp);
			return;
		}
		System.out.println(name);
		ProductDAO pd = new ProductDAO();
		try {
			List<Product> list = pd.findlike(name);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/product_list.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
