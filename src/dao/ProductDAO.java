package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import po.Product;
import utils.C3P0Util;

public class ProductDAO {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	// 分页查询
	public List<Product> findByPage(int pageNo, int pageSize) throws Exception {
		String sql = "select * from `products` limit " + (pageNo - 1)
				* pageSize + "," + pageSize;
		List<Product> list = (List<Product>) qr.query(sql, new BeanListHandler(
				Product.class));
		return list;
	}

	// 按id查询
	public Product findById(String id) throws Exception {
		String sql = "select * from `products` where `id`=?";
		Product p = (Product) qr.query(sql, new BeanHandler(Product.class), id);
		return p;
	}

	// 总条数
	public int getTotal() throws Exception {
		String sql = "select count(*) from `products`";
		Long t = qr.query(sql, new ScalarHandler());
		return t.intValue();
	}

	// 模糊查询
	public List<Product> findlike(String name) throws Exception {
		String sql = "select * from products where `name` like '%" + name
				+ "%'";
		List<Product> listp = (List<Product>) qr.query(sql,
				new BeanListHandler(Product.class));
		return listp;
	}

	// 购买后库存减少
	public void jian(int num, String id) throws Exception {
		String sql = "update  products set pnum=pnum-? where id=?";
		qr.update(sql, num, id);
	}
}
