package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int goodsNo;
	private int userNo;
	private String goodsName;
	private String goodsImage;
	private int price;
	private int quantity;
	private String introduction;
	private int soldoutFlag;
	private Timestamp registerDate;
	
	public Goods() {
		
	}
	
	public Goods(int goodsNo, int userNo) {
		this.goodsNo = goodsNo;
		this.userNo = userNo;
	}
		
	public Goods(int goodsNo, int userNo, String goodsName, String goodsImage,
			int price, int quantity, String introduction, int soldoutFlag, Timestamp registerDate) {
		
		this.goodsNo = goodsNo;
		this.userNo = userNo;
		this.goodsName = goodsName;
		this.goodsImage = goodsImage;
		this.price = price;
		this.quantity = quantity;
		this.introduction = introduction;
		this.soldoutFlag = soldoutFlag;
		this.registerDate = registerDate;
		
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getSoldoutFlag() {
		return soldoutFlag;
	}

	public void setSoldoutFlag(int soldoutFlag) {
		this.soldoutFlag = soldoutFlag;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	
	
}
