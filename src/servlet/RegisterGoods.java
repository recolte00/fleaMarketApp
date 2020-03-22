package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsNoDAO;
import model.Goods;

@WebServlet("/RegisterGoods")
public class RegisterGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String goodsName = request.getParameter("goodsName");
		String goodsImage = request.getParameter("goodsImage");
		String introduction = request.getParameter("introduction");
		
		int userNo = -1;
		int goodsNo = -1;
		int price = -1;
		int quantity = -1;
		int soldoutFlag = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		// 現在日時をセット
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String sRegisterDate = sdf.format(timestamp);
		Timestamp registerDate = null;
		try {
			userNo = Integer.parseInt(request.getParameter("userNo"));
			price = Integer.parseInt(request.getParameter("price"));
			quantity = Integer.parseInt(request.getParameter("quantity"));
			registerDate = new Timestamp(sdf.parse(sRegisterDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GoodsNoDAO dao = new GoodsNoDAO();
		goodsNo = dao.findGoodsNo(userNo);
			
		Goods goods = new Goods(goodsNo, userNo, goodsName, goodsImage, price, quantity, introduction, soldoutFlag, registerDate);
		request.setAttribute("goods", goods);
		//フォワード
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/jsp/registerGoodsConfirm.jsp");
		dispatcher.forward(request, response);
	}
}