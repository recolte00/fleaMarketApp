package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.GoodsDetail;

public class GoodsDetailDAO {

	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";

	private final String DB_USER = "root";

	private final String DB_PASS = "Market00";

	public List<GoodsDetail> findGoodsDetail(int userNo, int goodsNo) {
		Connection conn = null;
		List<GoodsDetail> goodsDetail = new ArrayList<GoodsDetail>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文の準備
			String sql = "SELECT " + "G.GOODS_NO, " + "G.USER_NO, " + "G.GOODS_NAME, " + "G.GOODS_IMAGE, "
					+ "G.GOODS_PRICE, " + "G.GOODS_QUANTITY, " + "G.GOODS_INTRODUCTION, " + "G.SOLDOUT_FLAG, "
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
				String goodsName = rs.getString("G.GOODS_NAME");
				String goodsImage = rs.getString("G.GOODS_IMAGE");
				int price = rs.getInt("G.GOODS_PRICE");
				int quantity = rs.getInt("G.GOODS_INTRODUCTION");
				String introduction = rs.getString("G.INTRODUCTION");
				int soldoutFlag = rs.getInt("G.SOLDOUT_FLAG");
				Timestamp registerDate = rs.getTimestamp("G.REGISTERDATE");
				String userId = rs.getString("U.USER_ID");

				GoodsDetail goods = new GoodsDetail(goodsNo, userNo, goodsName, goodsImage, price, quantity,
						introduction, soldoutFlag, registerDate, userId);
				goodsDetail.add(goods);
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
		return goodsDetail;

	}
}
