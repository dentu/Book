package po;

import java.util.Date;
import java.util.List;

public class Order {
	private String id;
	private double money;
	private String receiverAddress;
	private String receiverName;
	private String receiverPhone;
	private int paystate;
	private Date ordertime;
	private int user_id;
	private List<OrderItem> items;// 订单明细

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String id, double money, String receiverAddress,
			String receiverName, String receiverPhone, Date ordertime,
			int user_id) {
		super();
		this.id = id;
		this.money = money;
		this.receiverAddress = receiverAddress;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.ordertime = ordertime;
		this.user_id = user_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", money=" + money + ", receiverAddress="
				+ receiverAddress + ", receiverName=" + receiverName
				+ ", receiverPhone=" + receiverPhone + ", paystate=" + paystate
				+ ", ordertime=" + ordertime + ", user_id=" + user_id + "]";
	}

}
