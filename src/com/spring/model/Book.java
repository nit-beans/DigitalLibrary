package com.spring.model;

public class Book {
	private int Id;
	private String BookName;
	private String BookAuthor;
	private String BookCategory;
	private int BookISBN;

	public Book() {

	}

	public Book(int Id, String bookName, String bookAuthor, String bookCategory, int bookISBN) {

		this.Id = Id;
		BookName = bookName;
		BookAuthor = bookAuthor;
		BookCategory = bookCategory;
		BookISBN = bookISBN;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookAuthor() {
		return BookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}

	public String getBookCategory() {
		return BookCategory;
	}

	public void setBookCategory(String bookCategory) {
		BookCategory = bookCategory;
	}

	public int getBookISBN() {
		return BookISBN;
	}

	public void setBookISBN(int bookISBN) {
		BookISBN = bookISBN;
	}

}