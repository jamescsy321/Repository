package test;

import org.junit.Test;

import model.logBean;
import model.logDao;

public class logTest {

	@Test
	public void testLog() throws Exception {
		String uID = "abc";
		
		logBean bean = new logBean();
		bean.setuID(uID);
		
		logDao dao = new logDao();
		
		logBean result =dao.select("abc");
		String id = result.getuID();
		String name = result.getuName();
		String  email = result.getemail();
		System.out.println("id="+id);
		System.out.println("name="+name);
		System.out.println("email="+email);
		//logBean result = new logBean();
		System.out.println("result="+result);
	}
}
