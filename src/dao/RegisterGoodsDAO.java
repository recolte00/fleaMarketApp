package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class RegisterGoodsDAO {
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
	private final String DB_USER = "root";
	private final String DB_PASS = "Market00";
	
	public int insertGoods(int userNo, String goodsName, String goodsImage, 
							int price, int quantity, String introduction, Timestamp registerDate) {
		Connection conn = null;
		int num = 0;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			//INSERT文の準備
			String sql = 
					"INSERT INTO GOODS ("
					+" USER_NO,"
					+" GOODS_NO,"
					+" GOODS_NAME,"
					+" GOODS_IMAGE,"
					+" GOODS_PRICE,"
					+" GOODS_QUANTITY,"
					+" GOODS_INTRODUCTION,"
					+" REGISTER_DATE"
					+" )"
					+" VALUES("
					+" ?,"
					+" ?,"
					+" ?,"
					+" ?,"
					+" ?,"
					+" ?,"
					+" ?,"
					+" DATE_FORMAT(NOW(), '%Y%m%d')"
					+");";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userNo);
			pStmt.setInt(2, 0);
			pStmt.setString(3, goodsName);
			pStmt.setString(4, goodsImage);
			pStmt.setInt(5, price);
			pStmt.setInt(6, quantity);
			pStmt.setString(7, introduction);
			
		//INSERTを実行
		num = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
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