package model;

import java.sql.Timestamp;
import java.util.List;

import dao.GoodsListDAO;
import dao.GoodsNoDAO;
import dao.RegisterGoodsDAO;

public class RegisterGoodsLogic {
	
	public boolean register(Goods goods) {
		int userNo = goods.getUserNo();
		String goodsName = goods.getGoodsName();
		String goodsImage = goods.getGoodsImage();
		int price = goods.getPrice();
		int quantity = goods.getQuantity();
		String introduction = goods.getIntroduction();
		Timestamp registerDate = goods.getRegisterDate();
		GoodsNoDAO nDao = new GoodsNoDAO();
		int goodsNo = nDao.findGoodsNo(userNo);
		GoodsListDAO gDao = new GoodsListDAO();
		List<Goods> checkG = gDao.checkGoods(goodsNo, userNo);
			if(checkG.size() != 0) {
				return false;
			}
			RegisterGoodsDAO dao = new RegisterGoodsDAO();
			dao.insertGoods(userNo, goodsName, goodsImage, price, quantity, introduction, registerDate);
			
			return true;
	}
}
