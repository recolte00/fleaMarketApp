package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.sql.Timestamp;
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
	
	@Override
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		
		final String MALE = "1";
		final String FEMALE = "2";
		
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String userId = request.getParameter("userId");
		String userPostCode = request.getParameter("userPostCode");
		String userAddress = request.getParameter("userAddress");
		String userGender = request.getParameter("userGender");
		
		/*
		//郵便番号入力
		String urlString = "url" + "?zipcode=" + userAddress;
		//URL作って接続
		java.net.URL url = new java.net.URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		//JSONデータの読み込み
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String tmp;
		while ((tmp = in.readLine()) != null) {
			
		}
		//終了処理
		in.close();
		conn.disconnect();
		*/
		
		if(MALE.equals(userGender)) {
			userGender = "Male";
		} else if(FEMALE.equals(userGender)) {
			userGender = "Female";
		} else {
			userGender = "Others";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		String sUserBirthDate = request.getParameter("userBirthDate");
		Timestamp userBirthDate = null;
		Date date = null;
		
		try {
			date = sdf.parse(sUserBirthDate);
			userBirthDate = new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//登録するユーザの情報を設定
		User registerUser = new User(userId, name, pass, userPostCode,
				userAddress, userGender, userBirthDate);
		//セッションスコープに登録ユーザを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}
}