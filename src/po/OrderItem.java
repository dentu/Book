package po;

public class OrderItem {
	private String orderid;
	private String productid;
	private String pname;
	private double price;
	private int buynum;
	private double subtotal;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(String productid, String pname, double price, int buynum,
			double subtotal) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.price = price;
		this.buynum = buynum;
		this.subtotal = subtotal;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "OrderItem [orderid=" + orderid + ", productid=" + productid
				+ ", pname=" + pname + ", price=" + price + ", buynum="
				+ buynum + ", subtotal=" + subtotal + "]";
	}

}
