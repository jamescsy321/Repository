package model;

import java.util.Arrays;
public class UserService {
  private logDao logdao=new logDao();
//  public static void main(String[] args) throws Exception {
//	UserService user = new UserService();
//	logBean login = user.login("abc", "123456");
//	String email = login.getemail();
//	System.out.println(email);
//	System.out.println("login="+login);
//}
	//比對資料庫與用戶輸入資料是否相同
	public logBean login(String uID,String pwd) throws Exception  {
		logBean user = logdao.select(uID);
		if(user!=null) {
			if(pwd!=null || pwd.length()!=0) {
				byte[] pass = user.getpwd();  //get from database
				byte[] temp = pwd.getBytes(); //user input
				if(Arrays.equals(pass, temp)){
					return user;
				}
			}
		}
		
		return null;
		
	}

}
