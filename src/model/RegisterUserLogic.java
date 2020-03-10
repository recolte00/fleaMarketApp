package model;

import java.sql.Timestamp;
import java.util.List;

import dao.LoginDAO;
import dao.RegisterDAO;

public class RegisterUserLogic {
	
	public boolean register(User user) {
		String userId = user.getUserId();
		String userName = user.getUserName();
		String pass = user.getPass();
		String userPostCode = user.getUserPostCode();
		String userAddress = user.getUserAddress();
		String userGender = user.getUserGender();
		Timestamp userBirthDate = user.getUserBirthDate();
		
		RegisterDAO rDao = new RegisterDAO();
		LoginDAO lDao = new LoginDAO();
		List<User> userList = lDao.findUsers(userId, pass);
		if(userList.size() == 1){
			return false;
		}	
		rDao.insertUser(userId, userName, pass, userPostCode, userAddress, userGender, userBirthDate);
		return true;
	}

}
