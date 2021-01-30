package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.OrderDAO;
import po.Order;
import po.User;
import utils.IdUtils;

@WebServlet("/createorder")
public class CreateOrderServlet extends HttpServlet {
		public void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			Order order=new Order();
			String orderid=IdUtils.getUUID();
			User loginuser=(User)req.getSession().getAttribute("loginuser");
			try {
				BeanUtils.populate(order, req.getParameterMap());
				//补全信息
				order.setId(orderid);//唯一编号
				order.setUser_id(loginuser.getId());
				order.setOrdertime(new Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
			OrderDAO dao=new OrderDAO();
			try {
				//保存订单
				dao.save(order);
				//复制购物车到订单明细
				dao.copyCart(loginuser.getId(), orderid);
				//清空购车
				dao.clearCart(loginuser.getId());
				//转到成功网页
				req.getRequestDispatcher("/createOrderSuccess.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
