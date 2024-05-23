package model;

public class Teacher {

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String userName;
	private String password;
	private String address;
	private String phoneNum;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	 public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", phoneNum=" + phoneNum + "]";
	}
	public Teacher(int id, String userName, String password, String address, String phoneNum) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}