package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import po.Cart;
import po.User;
import utils.C3P0Util;

public class CartDAO {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	// 保存
	public void save(Cart cart) throws Exception {
		String sql = "insert into cart values(?,?,?)";
		qr.update(sql, cart.getUerid(), cart.getProductid(), cart.getBuynum());
	}

	// 按用户查询购物
	public List<Cart> findByUser(int uid) throws Exception {
		String sql = "SELECT userid,productid,`name` AS pname,price,buynum,pnum,price*buynum AS subtotal "
				+ "FROM cart JOIN products "
				+ "ON cart.productid=products.id where userid=?";
		List<Cart> list = (List<Cart>) qr.query(sql, new BeanListHandler(
				Cart.class), uid);
		return list;
	}

	// 按用户删除购物
	public void delitem(int userid, String productid) throws Exception {
		String sql = "delete from cart where userid=? and productid=?";
		qr.update(sql, userid, productid);
	}

	public void addNum(int num, int userid, String productid) throws Exception {
		String sql = "update cart set buynum=buynum+? where userid=? and productid=?";
		qr.update(sql, num, userid, productid);
	}

	// 查找物品是否在购物车
	public Cart findBypid(int uid, String pid) throws Exception {
		String sql = "select * from cart where userid=? and productid=?";
		Cart cart = (Cart) qr.query(sql, new BeanHandler(Cart.class), uid, pid);
		return cart;
	}

	// 修改购买数量
	public void buyuum(int num, int uid, String pid) throws Exception {
		String sql = "update cart set buynum=buynum+? where userid=? and productid=?";
		qr.update(sql, num, uid, pid);
	}
}
