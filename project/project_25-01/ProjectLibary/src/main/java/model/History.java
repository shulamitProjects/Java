package model;

public class History {
	private int id_person;
	private int id_book;
	private String type;
	public History(int id_person, int id_book, String type) {
		super();
		this.id_person = id_person;
		this.id_book = id_book;
		this.type = type;
	}
	public int getId_person() {
		return id_person;
	}
	public void setId_person(int id_person) {
		this.id_person = id_person;
	}
	public int getId_book() {
		return id_book;
	}
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "History [id_person=" + id_person + ", id_book=" + id_book + ", type=" + type + "]";
	}
	
}
