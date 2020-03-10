package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class RegisterDAO {
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL =	 "jdbc:mysql://localhost:3306/mydb";
	private final String DB_USER = "root";
	private final String DB_PASS = "Market00";
	
	public int insertUser(String userId, String userName, String pass, String userPostCode, 
			String userAddress, String userGender, Timestamp userBirthDate){
		Connection conn = null;
		int num = 0;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			//INSERT文の準備
			String sql = 
					"INSERT INTO USER ("  
					+"	USER_ID," 
					+"	USER_NAME,"
					+"	USER_PASSWORD," 
					+"	USER_POST_CODE," 
					+"	USER_ADDRESS," 
					+"	USER_GENDER,"
					+"	USER_BIRTH_DATE," 
					+"	REGISTER_DATE" 
					+"	 )"  
					+"	VALUES("  
					+" ?,"
					+" ?,"
					+" ?,"
					+" ?,"
					+" ?,"
					+" ?,"
					+" ?,"
					+" now());";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			pStmt.setString(2, userName);
			pStmt.setString(3, pass);
			pStmt.setString(4, userPostCode);
			pStmt.setString(5, userAddress);
			if("Male".equals(userGender)) {
				pStmt.setString(6, "1");
			} else if ("Female".equals(userGender)) {
				pStmt.setString(6, "2");
			} else {
				pStmt.setString(6, "0");
			}
			pStmt.setTimestamp(7, userBirthDate);
			
		// INSERTを実行
		num = pStmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return num;
	}
}