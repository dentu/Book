package dao;

import java.util.List;

import po.Product;

public class TestProductDAO {
	public static void main(String[] args) throws Exception {
		// testGetToatal();
		// testFindByPage();
		// testFindByid();
		// finflike();
	}

	private static void finflike() throws Exception {
		// TODO Auto-generated method stub
		ProductDAO pd = new ProductDAO();
		System.out.println(pd.findlike("j"));
	}

	private static void testFindByid() throws Exception {
		ProductDAO dao = new ProductDAO();
		Product p = dao.findById("A03");
		System.out.println(p);

	}

	private static void testFindByPage() throws Exception {
		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.findByPage(2, 4);
		for (Product p : list) {
			System.out.println(p);
		}

	}

	private static void testGetToatal() throws Exception {
		ProductDAO dao = new ProductDAO();
		int t = dao.getTotal();
		System.out.println(t);

	}
}
