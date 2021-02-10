package po;

import java.util.Date;

public class User {

	int id;// ` INT(11) NOT NULL AUTO_INCREMENT,
	String username;// ` VARCHAR(20) NOT NULL,
	String password;// ` VARCHAR(20) NOT NULL,
	String gender;// ` VARCHAR(2) DEFAULT NULL,
	String email;// ` VARCHAR(50) DEFAULT NULL,
	String telephone;// ` VARCHAR(20) DEFAULT NULL,
	String introduce;// ` VARCHAR(100) DEFAULT NULL,
	Date registTime;// ` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE
					// CURRENT_TIMESTAMP,

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password, String gender,
			String email, String telephone, String introduce, Date registTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.telephone = telephone;
		this.introduce = introduce;
		this.registTime = registTime;
	}

	public User(int id, String password, String gender, String telephone) {
		super();
		this.id = id;
		this.password = password;
		this.gender = gender;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", gender=" + gender + ", email=" + email
				+ ", telephone=" + telephone + ", introduce=" + introduce
				+ ", registTime=" + registTime + "]";
	}

}
