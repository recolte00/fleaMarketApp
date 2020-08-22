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
import javax.servlet.http.HttpSession;

import dao.GoodsDetailDAO;
import model.GoodsDetail;

@WebServlet("/GoodsDetail")
public class ToGoodsDetail extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータの取得
		int goodsNo = 0;
		int userNo = 0;
		int price = 0;
		int quantity = 0;
		int soldoutFlag = 0;
		String goodsName = request.getParameter("goodsName");
		String goodsImage = request.getParameter("goodsImage");
		String introduction = request.getParameter("introduction");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		String sRegisterDate = request.getParameter("registerDate");
		Timestamp registerDate = null;
		try {
			goodsNo = Integer.parseInt(request.getParameter("goodsNo"));
			userNo = Integer.parseInt(request.getParameter("userNo"));
			price = Integer.parseInt(request.getParameter("price"));
			quantity = Integer.parseInt(request.getParameter("quantity"));
			soldoutFlag = Integer.parseInt(request.getParameter("soldoutFlag"));
			registerDate = new Timestamp(sdf.parse(sRegisterDate).getTime());
		} catch (ParseException e){
			e.printStackTrace();
		}
		//DAOインスタンス生成
		GoodsDetailDAO dao = new GoodsDetailDAO();
		String userId = dao.findGoodsDetail(userNo, goodsNo);		
		//表示する商品詳細を設定
		GoodsDetail goodsDetail = new GoodsDetail(
				goodsNo, userNo, goodsName, goodsImage, price, 
				quantity, introduction, soldoutFlag, registerDate, userId);
		//セッションスコープに商品詳細を保存
		HttpSession session = request.getSession();
		session.setAttribute("goodsDetail", goodsDetail);
		
		//ページ遷移
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/goodsDetail.jsp");
		dispatcher.forward(request, response);
		}
}