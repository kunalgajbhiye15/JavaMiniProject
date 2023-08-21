package com.entity;

public class Book {
	
	
	private int id;
	private String bookName;
	private String doi;
	private String authorName;
	private String price;
	
	public Book() {
		//super();
	}
	
	public Book(String bookName, String doi, String authorName, String price) {
		//super();
		this.bookName = bookName;
		this.doi = doi;
		this.authorName = authorName;
		this.price = price;
	}
	
	

	public Book(int id, String bookName, String doi, String authorName, String price) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.doi = doi;
		this.authorName = authorName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", doi=" + doi + ", authorName=" + authorName + ", price="
				+ price + "]";
	}
	
	
	
	

}
