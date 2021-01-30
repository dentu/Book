package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.Page;
import po.Product;
import dao.ProductDAO;
@WebServlet("/list")
public class ListServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				req.setCharacterEncoding("UTF-8");
				resp.setContentType("application/json;charset=utf-8");
				PrintWriter out=resp.getWriter();
				
				int pageNo=Integer.parseInt(req.getParameter("pageNo"));
				ProductDAO pdao=new ProductDAO();
				try {
					List<Product> list=pdao.findByPage(pageNo, 4);
					int total=pdao.getTotal();
					Page page = new Page(); 
					page.setItems(list);
					page.setTotalPage((total%4==0)?total/4:total/4+1);// 页数
					ObjectMapper mapper=new ObjectMapper();
					String json=mapper.writeValueAsString(page);//将对象集合转换为json字符串
					out.print(json);
				} catch (Exception e) {
					e.printStackTrace();
				}
				out.flush();
				out.close();
	}

}
