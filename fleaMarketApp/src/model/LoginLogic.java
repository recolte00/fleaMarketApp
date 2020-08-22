package model;

import java.util.List;

import dao.LoginDAO;

public class LoginLogic {
	public boolean execute(User user) {
		
		String userId = user.getUserId();
		String pass = user.getPass();
		
		LoginDAO dao = new LoginDAO();
		List<User> userList = dao.findUsers(userId, pass);
		if(userList.size() == 1){
				return true;
		}	
		return false;
	}
}