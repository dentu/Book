package po;

import java.util.List;

// 把书籍信息等打包
public class Page {
	private int totalPage;
	private List<Product> items;

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

}
