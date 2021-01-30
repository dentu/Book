package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.User;
import dao.UserDAO;
@WebServlet("/log")
public class LoginServlet  extends HttpServlet {

		public void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			//接收username,password
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			UserDAO dao=new UserDAO();
			try {
				User user=dao.findByUserName(username);
				if(user==null || !user.getPassword().equals(password)){
					req.setAttribute("msg", "账号或者密码错误!");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
					return;
				}else{
					req.getSession().setAttribute("loginuser", user);
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
