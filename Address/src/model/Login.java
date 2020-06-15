package model;

public class Login {
	private String id;
	private String password;
	public Login(String name, String password) {
		this.id = name;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
}
