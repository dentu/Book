package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import po.User;
import utils.C3P0Util;

public class UserDAO {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	// 注册：保存
	public void save(User user) throws Exception {
		String sql = "insert into `user`(`username`,`PASSWORD`,`gender`,`email`,`telephone`,`introduce`,`registTime`) values(?,?,?,?,?,?,?)";
		qr.update(sql, user.getUsername(), user.getPassword(),
				user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(), user.getRegistTime());
	}

	// 登录：查询
	public User findByUserName(String name,String pwd) throws Exception {
		String sql = "select * from `user` where `username`=? and `PASSWORD`=?";
		User user = (User) qr.query(sql, new BeanHandler(User.class), name,pwd);
		return user;
	}

	// 修改
	public void update(User user) throws Exception {
		String sql = "update `user` set `PASSWORD`=?,`gender`=?,`telephone`=? where `id`=?";
		qr.update(sql, user.getPassword(), user.getGender(),
				user.getTelephone(), user.getId());
	}
}
