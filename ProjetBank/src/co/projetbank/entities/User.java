package co.projetbank.entities;

public class User {
	private String Login ; 
	private String Pwd ; 
	
	public User(String Login , String Pwd) {
		this.Login=Login ; 
		this.Pwd=Pwd ; 
	}

	public String getPwd() {
		return Pwd;
	}

	public void setPwd(String pwd) {
		Pwd = pwd;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}
	

}
