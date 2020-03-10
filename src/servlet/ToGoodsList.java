package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodsListDAO;
import model.Goods;

@WebServlet("/Goods")
public class ToGoodsList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			request.setCharacterEncoding("UTF-8");
			//DAOインスタンス生成
			GoodsListDAO dao = new GoodsListDAO();
			//GoodsListインスタンス（グッズ情報）の取得
			List<Goods> goodsList = dao.findGoods();
			//セッションスコープに商品リストを保存
			HttpSession session = request.getSession();
			session.setAttribute("goodsList", goodsList);
			
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/goodsList.jsp");
		dispatcher.forward(request, response);
	}
}