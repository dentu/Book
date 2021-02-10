package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/global")
// 接受全局变量
public class GlobalVariable extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=utf-8");
		// 获取网页的book的id
		String id = req.getParameter("bookId");
		// 设置book的id
		req.getSession().setAttribute("book_id", id);

	}

}
