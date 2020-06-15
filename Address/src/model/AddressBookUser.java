package model;
import java.io.Serializable;

public class AddressBookUser implements Serializable {
	private String id;
	//private String name; //ユーザー名
	private String password; //パスワード

	public AddressBookUser() {}
//	public AddressBookUser(String id, String name, String password) {
//		this.id = id;
//		this.name = name;
//		this.password = password;
//	}
	public AddressBookUser(String id,  String password) {
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
//	public String getName() {
//		return name;
//	}
	public String getPassword() {
		return password;
	}
}
