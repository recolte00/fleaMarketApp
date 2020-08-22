package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserNoDAO;
import model.User;


@WebServlet("/ToGoodsRegi")
public class ToGoodsRegistration extends HttpServlet {
private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		HttpSession session = request.getSession(false);
		User loginUser = (User) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		String pass = loginUser.getPass();
		
		UserNoDAO dao = new UserNoDAO();
		String userNo = dao.findUserNo(userId, pass);
		
		request.setAttribute("userNo", userNo);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/goodsRegiForm.jsp");
		dispatcher.forward(request, response);
	}
}