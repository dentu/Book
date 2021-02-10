package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import po.Cart;
import po.Order;
import po.OrderItem;
import utils.C3P0Util;

public class OrderDAO {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	public void save(Order o) throws Exception {
		String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)";
		qr.update(sql, o.getId(), o.getMoney(), o.getReceiverAddress(),
				o.getReceiverName(), o.getReceiverPhone(), o.getPaystate(),
				o.getOrdertime(), o.getUser_id());
	}

	// 复制购物车到订单明细表
	public void copyCart(int userid, String orderid) throws Exception {
		String sql = "INSERT INTO orderitem SELECT '" + orderid
				+ "',productid,buynum FROM cart where userid=?";
		qr.update(sql, userid);
	}

	// 清空购车
	public void clearCart(int userid) throws Exception {
		String sql = "delete FROM cart where userid=?";
		qr.update(sql, userid);
	}

	// 按订单编号查询订单明细
	public List<OrderItem> findItem(String oid) throws Exception {
		String sql = "select orderid, productid,name as pname,price,buynum,price*buynum as subtotal "
				+ ""
				+ "from orderitem join products on orderitem.productid=products.id where orderid=? ";
		List<OrderItem> list = (List<OrderItem>) qr.query(sql,
				new BeanListHandler(OrderItem.class), oid);
		return list;
	}

	// 按用户查询订单(含订单明细的组合查询)
	public List<Order> findOrder(int uid) throws Exception {
		String sql = "select * from orders where user_id=? order by ordertime desc";
		List<Order> list = (List<Order>) qr.query(sql, new BeanListHandler(
				Order.class), uid);
		for (Order o : list) {
			List<OrderItem> items = findItem(o.getId());
			o.setItems(items);

		}
		return list;
	}

	// 删除订单
	public void delorder(String id) throws Exception {
		String sql1 = "delete from orders where id=?";
		String sql2 = "delete from orderitem where orderid=?";
		qr.update(sql1, id);
		qr.update(sql2, id);
	};

	// 按订单编号查找金额
	public Order findByid(String id) throws Exception {
		String sql = "select * from orders where id=?";
		Order o = (Order) qr.query(sql, new BeanHandler(Order.class), id);
		return o;
	}

	// 已支付
	public void payzt(String zt) throws Exception {
		String sql = "update orders set paystate=1 where id=?";
		qr.update(sql, zt);
	}

}
