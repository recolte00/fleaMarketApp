package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import model.RegisterGoodsLogic;

@WebServlet("/ToRegiGoodsDone")
public class ToRegiGoodsDone extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		//リクエストスコープに保存された登録商品を取得
		int goodsNo = 0;
		int userNo = 0;
		int price = 0;
		int quantity = 0;
		int soldoutFlag = 0;
		Timestamp registerDate = null;
		//TODO try文
		try {
			goodsNo = Integer.parseInt(request.getParameter("goodsNo"));
			userNo = Integer.parseInt(request.getParameter("userNo"));
			price = Integer.parseInt(request.getParameter("price"));
			quantity = Integer.parseInt(request.getParameter("quantity"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String goodsName = request.getParameter("goodsName");
		String goodsImage = request.getParameter("goodsImage");
		String introduction = request.getParameter("introduction");
		Goods registerGoods = new Goods(goodsNo, userNo, goodsName, 
				goodsImage, price, quantity, introduction, soldoutFlag, registerDate);
	
		//登録処理の呼び出し
		RegisterGoodsLogic logic = new RegisterGoodsLogic();
		logic.register(registerGoods);	
			
		//設定されたフォワード先に遷移
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/goodsRegiDone.jsp");
		dispatcher.forward(request, response);
	}
	
}
