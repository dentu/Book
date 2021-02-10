package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.User;
import dao.UserDAO;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=utf-8");
		// 接收username,password
		String username = req.getParameter("acct");
		String password = req.getParameter("passwd");
		
		PrintWriter out = resp.getWriter();
		
		UserDAO dao = new UserDAO();
		try {
			User user = dao.findByUserName(username,password);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);// 将对象集合转换为json字符串
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
