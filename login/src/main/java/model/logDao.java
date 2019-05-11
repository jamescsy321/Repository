package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class logDao {

	private static final String CLASSFORNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=TestDB";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	private static final String SELECT = "select * from Users where uID=?";

	// select
	public logBean select(String uID) throws Exception {
		logBean result = null;
			try {
				Class.forName(CLASSFORNAME);
				Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT);
				pstmt.setString(1, uID);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					result = new logBean();
					result.setuID(rs.getString("uID"));
					result.setpwd(rs.getBytes("pwd"));
					result.setuName(rs.getString("uName"));
					result.setemail(rs.getString("email"));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		return result;
	}

}
