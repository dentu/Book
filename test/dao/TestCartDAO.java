package dao;

import java.util.List;

import po.Cart;
import po.Order;
import po.OrderItem;

public class TestCartDAO {
	public static void main(String[] args) throws Exception {
		// testSave();
		// testfindbynum();
		testfindOrder();
	}

	private static void testfindOrder() throws Exception {
		OrderDAO dao = new OrderDAO();
		List<Order> list = dao.findOrder(1);
		for (Order o : list) {
			System.out.println(o);
			for (OrderItem oi : o.getItems()) {
				System.out.println("\t" + oi);
			}
		}

	}

	private static void testfindbynum() throws Exception {
		// TODO Auto-generated method stub
		CartDAO dao = new CartDAO();

	}

	private static void testSave() throws Exception {
		CartDAO dao = new CartDAO();
		Cart cart = new Cart(2, "A02", 1);
		dao.save(cart);
		System.out.println("OK");

	}
}
