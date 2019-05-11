package model;

public class logBean {
	private String uID;
	private byte[] pwd;
	private String uName;
	private String email;

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public byte[] getpwd() {
		return pwd;
	}

	public void setpwd(byte[] pwd) {
		this.pwd = pwd;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
}
