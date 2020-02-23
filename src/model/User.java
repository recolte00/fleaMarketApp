package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	private String userName;
	private String pass;
	private String userId;
	private String userPostCode;
	private String userAddress;
	private int userGender;
	private Date userBirthDate;
	private Date registerDate = date;
	
	public User() {
	}
	
	public User(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}
	
	public User(String userName, String pass, String userId, String userPostCode, 
			String userAddress, int userGender, Date userBirthDate, Date registerDate) {
		this.userName = userName;
		this.pass = pass;
		this.userId = userId;
		this.userPostCode = userPostCode;
		this.userAddress = userAddress;
		this.userGender = userGender;
		this.userBirthDate = userBirthDate;
		this.registerDate = registerDate;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPostCode() {
		return userPostCode;
	}

	public void setUserPostCode(String userPostCode) {
		this.userPostCode = userPostCode;
	}
	
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserGender() {
		return userGender;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}

	public Date getUserBirthDate() {
		return userBirthDate;
	}

	public void setUserBirthDate(Date userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
}
