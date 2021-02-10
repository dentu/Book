package servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import po.User;

//注册
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());// 自动封装上传数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 验证码比对
		String checkcode = (String) req.getSession().getAttribute("checkcode");
		String yzm = req.getParameter("yzm");
		if (!checkcode.equals(yzm)) {
			req.setAttribute("yzmmsg", "验证码错误!");
			req.setAttribute("user", user);
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
			return;
		}
		try {
			user.setRegistTime(new Date());
			UserDAO dao = new UserDAO();
			dao.save(user);
			req.getRequestDispatcher("/registerSuccess.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
