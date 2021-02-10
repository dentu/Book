package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import po.User;

@WebServlet("/updateuser")
public class UpdateuserServlet extends HttpServlet {
	// 验证码图片高度

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String oldpwd = req.getParameter("oldpwd");
		String newpwd = req.getParameter("newpwd");
		String tele = req.getParameter("telephone");

		User loginuser = (User) req.getSession().getAttribute("loginuser");
		if (!oldpwd.equals(loginuser.getPassword())) {
			req.setAttribute("msg", "原始密码错误!");
			req.getRequestDispatcher("/modifyuserinfo.jsp").forward(req, resp);
			return;
		}
		loginuser.setPassword(newpwd);
		loginuser.setTelephone(tele);
		// 将修改保存到数据库
		UserDAO dao = new UserDAO();
		try {
			dao.update(loginuser);
			req.getRequestDispatcher("/updateUserSuccess.jsp").forward(req,
					resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
