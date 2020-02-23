package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		//フォワード先
		String forwardPath = null;
		
		//サーブレットクラスの動作を決定する「action」の値をリクエストパラメータから取得
		String action = request.getParameter("action");
		
		//「登録の開始」をリクエストされた時の処理
		if(action == null) {
			//フォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		//登録確認画面から「登録実行」をリクエストされたときの処理
		}else if(action.contentEquals("done")) {
			//セッションスコープに保存された登録ユーザを取得
			HttpSession session = request.getSession();
			User registerUser = (User) session.getAttribute("registerUser");
			
			//登録処理の呼び出し
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.register(registerUser);
			
			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerUser");
			
			//登録後のフォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}
		//設定されたフォワード先に遷移
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
	
	protected void dopost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String userId = request.getParameter("userId");
		String userPostCode = request.getParameter("userPostCode");
		String userAddress = request.getParameter("userAddress");
		String sUserGender = request.getParameter("sUserGender");
		int userGender = Integer.parseInt(sUserGender);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		Date nowDate = new Date();
		String strDate = sdf.format(nowDate);
		Date userBirthDate = null;
		Date registerDate = null;
		String sUserBirthDate = request.getParameter("sUserBirthDate");
		
		try {
			userBirthDate = sdf.parse(sUserBirthDate);
			registerDate = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//登録するユーザの情報を設定
		User registerUser = new User(name, pass, userId, userPostCode,
				userAddress, userGender, userBirthDate, registerDate);
		//セッションスコープに登録ユーザを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}
}
