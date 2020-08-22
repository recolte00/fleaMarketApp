package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	private String userName;
	private String pass;
	private String userId;
	private String userPostCode;
	private String userAddress;
	private String userGender;
	private Timestamp userBirthDate;
	
	public User() {
	}
	
	public User(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}
	
	public User(String userId, String userName, String pass, String userPostCode, 
			String userAddress, String userGender, Timestamp userBirthDate) {
		
		this.userName = userName;
		this.pass = pass;
		this.userId = userId;
		this.userPostCode = userPostCode;
		this.userAddress = userAddress;
		this.userGender = userGender;
		this.userBirthDate = userBirthDate;
		
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

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Timestamp getUserBirthDate() {
		return userBirthDate;
	}

	public void setUserBirthDate(Timestamp userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

}
