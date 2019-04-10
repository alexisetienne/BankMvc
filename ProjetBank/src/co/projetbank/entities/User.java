package co.projetbank.entities;

public class User {
	private String Login ; 
	private String Pwd ; 
	private int IdU ; 
	
	public User(String Login , String Pwd , int IdU) {
		this.Login=Login ; 
		this.Pwd=Pwd ;
		this.IdU = IdU ; 
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

	public int getIdU() {
		return IdU;
	}

	public void setIdU(int idU) {
		IdU = idU;
	}
	

}
