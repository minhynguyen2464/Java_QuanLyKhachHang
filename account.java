package khachhang;

import java.io.Serializable;

public class account implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String username;
private String password;
private int type; //Type 1 = Admin, Type 2 = Guest
	public account(){
	}
	
	public account(String username, String password, int type) {
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	public String get_username() {
		return this.username;
	}
	public void set_username(String username) {
		this.username = username;
	}
	public String get_password() {
		return this.password;
	}
	public void set_password(String password) {
		this.password = password;
	}
	public int get_type() {
		return this.type;
	}
	public void set_type(int type) {
		this.type = type;
	}
	
	public String type_classify() {
		if (this.type==1)
			return "Admin";
		else 
			return "Guests";
	}
}
