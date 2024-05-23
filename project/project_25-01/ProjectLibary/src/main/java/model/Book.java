package model;

import java.util.Iterator;

public class Book {
private int idBook;
private String name;
private String aouther;
private String isBorrow;
private int idBorrow;

public int getIdBorrow() {
	return idBorrow;
}
public void setIdBorrow(int idBorrow) {
	this.idBorrow = idBorrow;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAouther() {
	return aouther;
}
public void setAouther(String aouther) {
	this.aouther = aouther;
}

public String getIsBorrow() {
	return isBorrow;
}

public int getIdBook() {
	return idBook;
}
public void setIdBook(int idBook) {
	this.idBook = idBook;
}
public void setIsBorrow(String isBorrow) {
	this.isBorrow = isBorrow;
}

public Book(int idBook, String name, String aouther) {
	super();
	this.idBook = idBook;
	this.name = name;
	this.aouther = aouther;
	this.isBorrow = "false";
	this.idBorrow = 0;
}
@Override
public String toString() {
	return "Book [idBook=" + idBook + ", name=" + name + ", aouther=" + aouther + ", isBorrow=" + isBorrow
			+ ", idBorrow=" + idBorrow + "]";
}
public Book() {
	
}

}
