package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Goods;

public class GoodsListDAO {
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL =	 "jdbc:mysql://localhost:3306/mydb";
	private final String DB_USER = "root";
	private final String DB_PASS = "Market00";
	
	public List<Goods> findGoods(){
		Connection conn = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			//SELECT文の準備
			String sql =
					"SELECT "
					+ "GOODS_NO, "
					+ "USER_NO, "
					+ "GOODS_NAME, "
					+ "GOODS_IMAGE, "
					+ "GOODS_PRICE, "
					+ "GOODS_QUANTITY, "
					+ "GOODS_INTRODUCTION, "
					+ "SOLDOUT_FLAG, "
					+ "REGISTER_DATE FROM GOODS;";
			
			Statement stmt = conn.createStatement();
			//SELECTを実行
			ResultSet rs = stmt.executeQuery(sql);
			//SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int goodsNo = rs.getInt("GOODS_NO");
				int userNo = rs.getInt("USER_NO");
				String goodsName = rs.getString("GOODS_NAME");
				String goodsImage = rs.getString("GOODS_IMAGE");
				int price = rs.getInt("GOODS_PRICE");
				int quantity = rs.getInt("GOODS_QUANTITY");
				String introduction = rs.getString("GOODS_INTRODUCTION");
				int soldoutFlag = rs.getInt("SOLDOUT_FLAG");
				Timestamp registerDate = rs.getTimestamp("REGISTER_DATE");
				
				Goods goods = new Goods(goodsNo, userNo, goodsName, goodsImage,
						 price, quantity, introduction, soldoutFlag, registerDate);
				goodsList.add(goods);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return goodsList;
	}
	public List<Goods> checkGoods(int goodsNo, int userNo){
		Connection conn = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			//SELECT文の準備
			String sql =
					"SELECT "
					+ "GOODS_NO, "
					+ "USER_NO "
					+"FROM GOODS "
					+ "WHERE GOODS_NO = ? "
					+ "AND USER_NO = ?;";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, goodsNo);
			pStmt.setInt(2, userNo);
			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();
			//SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int gNo = rs.getInt("GOODS_NO");
				int uNo = rs.getInt("USER_NO");
				Goods goods = new Goods(gNo, uNo);
				goodsList.add(goods);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return goodsList;
	}

}
