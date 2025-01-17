package model;

public class Student {
	private int id;
	private String userName;
	private String password;
	private String address;
	private String phoneNum;
	private int idBook;
	
	
	
	public Student() {
		super();
	}
	public Student(int id, String userName, String password, String address, String phoneNum) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.phoneNum = phoneNum;
		this.idBook = 0;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", phoneNum=" + phoneNum + ", idBook=" + idBook + "]";
	}

}