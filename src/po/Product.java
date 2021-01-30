package po;

public class Product {
	private String id;// ` VARCHAR(100) NOT NULL DEFAULT '',
	private String name;// ` VARCHAR(40) DEFAULT NULL,
	private double price;// ` DOUBLE DEFAULT NULL,
	private String category;// ` VARCHAR(40) DEFAULT NULL,
	private int pnum;// ` INT(11) DEFAULT NULL,
	private String imgurl;// ` VARCHAR(100) DEFAULT NULL,
	private String description;// ` VARCHAR(255) DEFAULT NULL,

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String name, double price, String category,
			int pnum, String imgurl, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.pnum = pnum;
		this.imgurl = imgurl;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", category=" + category + ", pnum=" + pnum + ", imgurl="
				+ imgurl + ", description=" + description + "]";
	}

}
