package dao;

import java.util.Date;

import po.User;

public class TestUserDAO {
	public static void main(String[] args) throws Exception{
//		testSave();成功
//		testFindByName();成功
		testUpdate();
	}

	private static void testUpdate()  throws Exception{
		User user=new User(1,"321","女","13819190101");
		UserDAO dao=new UserDAO();
		dao.update(user);
		System.out.println("OK");		
		
	}

	private static void testFindByName()  throws Exception{
		UserDAO dao=new UserDAO();
		User user=dao.findByUserName("madan");
		System.out.println(user);
		User user1=dao.findByUserName("abcd");
		System.out.println(user1);
	}

	private static void testSave()  throws Exception{
		User user=new User(0,"aaa","123","男","aa@qq.com","13708081234","askjaksd",new Date());
		UserDAO dao=new UserDAO();
		dao.save(user);
		System.out.println("OK");
		
	}
}
