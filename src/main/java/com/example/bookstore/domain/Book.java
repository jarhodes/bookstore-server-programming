package com.example.bookstore.domain;

public class Book {

	private long id;
	private String title;
	private int year;
	private String isbn;
	private double price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(long id, String title, int year, String isbn, double price) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", year=" + year + ", isbn=" + isbn + ", price=" + price + "]";
	}
	
	
	
}
