package model;

import java.util.List;

import dao.GoodsDetailDAO;

public class GoodsDetaiLogic {
	public boolean execute(GoodsDetail goodsDetail) {
		int goodsNo = goodsDetail.getGoodsNo();
		int userNo = goodsDetail.getUserNo();
		
		GoodsDetailDAO dao = new GoodsDetailDAO();
		List<GoodsDetail> goods = dao.findGoodsDetail(goodsNo, userNo);
		if(goods.size() == 1) {
			return true;
		}
		return false;
	}

}
