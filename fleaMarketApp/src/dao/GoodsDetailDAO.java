package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsDetailDAO {
	//userIdが一つかどうか確認するべき
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
	private final String DB_USER = "root";
	private final String DB_PASS = "Market00";

	public String findGoodsDetail(int userNo, int goodsNo) {
		Connection conn = null;
		String userId = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文の準備
			String sql = "SELECT "
					+ "U.USER_ID " + "FROM GOODS G LEFT JOIN USER U ON G.USER_NO = U.USER_NO " + "WHERE G.USER_NO = ? "
					+ "AND U.USER_NO = ?;";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userNo);
			pStmt.setInt(2, goodsNo);
			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();
			/*
			// 取得行が一行であるか確認
			rs.last();// 最後の行へ移動
			int numOfRow = rs.getRow();// 最後の行番号を取得
			rs.beforeFirst();// 最初の行へ戻る
			*/
			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				userId = rs.getString("U.USER_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userId;
	}
}
