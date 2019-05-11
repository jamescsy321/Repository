package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserService;
import model.logBean;


@WebServlet("/login.controller")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private UserService  userService;
   
   public void init() throws ServletException {
	   userService = new UserService();
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		        req.setCharacterEncoding("UTF-8");
		        //接收資料	
				String uID = req.getParameter("userid");
				String pwd = req.getParameter("userpwd");
				
				System.out.println(uID);
				System.out.println(pwd);
				//驗證資料
				Map<String, String> errors = new HashMap<String, String>();
				req.setAttribute("errors", errors);
				
				if(uID==null || uID.length()==0) {
					errors.put("username", "Please enter ID for login");
				}
				if(pwd==null || pwd.length()==0) {
					errors.put("password", "Please enter PWD for login");
				}
				
				if(errors!=null && !errors.isEmpty()) {
					req.getRequestDispatcher(
							"/login.jsp").forward(req, resp);
					return;
				}
				//呼叫DAO
				//logBean bean;
				
				logBean bean;
				try {
					bean = userService.login(uID, pwd);
					System.out.println("bean="+bean);
				
					
				
				
				//根據DAO執行結果返回VIEW
				if(bean==null) {
					errors.put("password", "Login failed, please try again.");
					req.getRequestDispatcher(
							"/login.jsp").forward(req, resp);
				} else {
					//成功便取得session
					HttpSession session = req.getSession();
					session.setAttribute("user", bean);
					
					//將結果導向另一隻jsp
					String path = req.getContextPath();
					resp.sendRedirect(path+"/loginSuccess.jsp");

				}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	}

}
