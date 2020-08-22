package servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.GoodsNoDAO;
import model.FileUploadLogic;
import model.Goods;

@MultipartConfig(location="/tmp")
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddhhMMss");
		sdf.setLenient(false);
		
		String goodsName = request.getParameter("goodsName");
		String introduction = request.getParameter("introduction");
		
		int userNo = -1;
		int goodsNo = -1;
		int price = -1;
		int quantity = -1;
		int soldoutFlag = 0;
		
		String goodsImage = null;
		//DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//画像ファイルを取得
		Part part = request.getPart("goodsImage");
		
		//画像名取得
		String imageName = this.getFileName(part);
		//String prefix = imageName;
		//String suffix = "";
		String uploadPath = null;
		
		
		// 現在日時をセット
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String sRegisterDate = sdf.format(timestamp);
		Timestamp registerDate = null;
		try {
			userNo = Integer.parseInt(request.getParameter("userNo"));
			price = Integer.parseInt(request.getParameter("price"));
			quantity = Integer.parseInt(request.getParameter("quantity"));
			imageName =  sdf2.format(new Timestamp(System.currentTimeMillis())) + imageName;
			uploadPath = getServletContext().getRealPath("/uploaded") + "/";
			registerDate = new Timestamp(sdf.parse(sRegisterDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Path file = null;
		Path cd = null;
		Path cf = null;
		String fullPath = "";
		Path fp = null;
		try {
			file = Paths.get(uploadPath);
			cd = Files.createDirectories(file);
			cf = Paths.get(cd.toString());
			fullPath = uploadPath + imageName; 
			fp = Paths.get(fullPath);
			cf = Files.createFile(fp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//File image = File.createTempFile(prefix + "_", suffix, new File(uploadPath));
		//imageName = imageName.substring(imageName.lastIndexOf('/') + 1).substring(imageName.lastIndexOf('\\')+1);
		
		FileUploadLogic fulLogic = new FileUploadLogic();
		fulLogic.execute(part, cf);
		
		//WEB-INF下でimgファイルを作成テスト
		String testPath = getServletContext().getRealPath("/WEB-INF/uploaded") + "/";
		testPath = testPath + imageName;
		Path testInf = Paths.get(testPath);
		cf = Files.createFile(testInf);
		fulLogic.execute(part, cf);
		
		// 画像の読み込み
		//BufferedImage img = ImageIO.read(new File(imageName));
		// 画像の書き込み
		//ImageIO.write(ImageIO.read(image), "jpg", new File(uploadPath));
		part.write(uploadPath + imageName);
		GoodsNoDAO dao = new GoodsNoDAO();
		goodsNo = dao.findGoodsNo(userNo);
		
		request.setAttribute("msg","商品画像");
		request.setAttribute("goodsImage", cf.toString());
		request.setAttribute("imageName", imageName);
		goodsImage = "http://localhost:8080/fleaMarketApp/uploaded/" + imageName;
		
		Goods goods = new Goods(goodsNo, userNo, goodsName, goodsImage, price, quantity, introduction, soldoutFlag, registerDate);
		request.setAttribute("goods", goods);
		//フォワード
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/jsp/registerGoodsConfirm.jsp");
		dispatcher.forward(request, response);
	}
	
	private String getFileName(Part part) {
		String name = null;
		for(String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"","").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
			break;
			}
		}
		return name;
	}
}