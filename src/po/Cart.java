package po;

public class Cart {
	private int uerid;
	private String productid;
	private String pname; //商品名称
	private double price;//价格
	private int buynum;//数量
	private int pnum;//库存
	private double subtotal;//小计
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int uerid, String productid, int buynum) {
		super();
		this.uerid = uerid;
		this.productid = productid;
		this.buynum = buynum;
	}
	public int getUerid() {
		return uerid;
	}
	public void setUerid(int uerid) {
		this.uerid = uerid;
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
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "Cart [uerid=" + uerid + ", productid=" + productid + ", pname="
				+ pname + ", price=" + price + ", buynum=" + buynum + ", pnum="
				+ pnum + ", subtotal=" + subtotal + "]";
	}
	
	
	
	
}
