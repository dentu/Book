package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.Product;
import dao.ProductDAO;

@WebServlet("/info")
public class InfoServlet  extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)	
			throws ServletException, IOException {
				req.setCharacterEncoding("UTF-8");
				resp.setContentType("application/json;charset=utf-8");
				PrintWriter out=resp.getWriter();
				String id=req.getParameter("id");
				try {
					ProductDAO dao=new ProductDAO();
					Product p=dao.findById(id);
					ObjectMapper mapper=new ObjectMapper();
					String json=mapper.writeValueAsString(p);//将对象集合转换为json字符串
					out.print(json);
				} catch (Exception e) {
					e.printStackTrace();
				}
				out.flush();
				out.close();
			}

}
