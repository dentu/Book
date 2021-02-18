package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.Page;
import po.Product;
import dao.ProductDAO;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//设置输出的格式
		resp.setContentType("application/json;charset=utf-8");
		//创建会话
		HttpSession session = req.getSession();
		session.setAttribute("book_id", null);
		//创建本输出方式
		PrintWriter out = resp.getWriter();

		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		ProductDAO pdao = new ProductDAO();
		try {
			List<Product> list = pdao.findByPage(pageNo, 4);
			int total = pdao.getTotal();
			Page page = new Page();
			page.setItems(list);
			page.setTotalPage((total % 4 == 0) ? total / 4 : total / 4 + 1);// 页数
			//创建Jackson核心对象 ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			/**
			 *转换方法
			 *1、writeValue(参数,obj)
			 *		参数:
			 *			File:将obj对象转换为JSON字符串,并保存到指定文件中
			 *			Writer:将obj对象转换为JSON字符串,并将JSON数据填充到字符输出流中
			 *			OutputStream:将obj对象转换为JSON字符串,并将JSON数据填充到字节输出流中
			 *2、writeValueAsString(obj)  将对象转换为json字符串
			 */
			String json = mapper.writeValueAsString(page);// 将对象集合转换为json字符串
			//向网页输出数据
			out.print(json);
			/**
			 * 第二种输出方式
			 * mapper.writeValue(resp.getWriter(),page)
			 * 							 File
			 *							 Writer
			 *							 OutputStream
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
