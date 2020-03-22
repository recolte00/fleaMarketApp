package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsNoDAO {
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
	private final String DB_USER = "root";
	private final String DB_PASS = "Market00";
	
	public int findGoodsNo(int userNo){
		Connection conn = null;
		int goodsNo = 0;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		
			//SELECT文の準備
			String sql = 
				"SELECT MAX(GOODS_NO) FROM GOODS "
				+ "WHERE USER_NO = ?;";
				
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userNo);
			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			// SELECT文の結果をuserNoに格納
			while (rs.next()) {
				goodsNo = Integer.parseInt(rs.getString("MAX(GOODS_NO)"));
			}
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
		return ++goodsNo;
	}
}
