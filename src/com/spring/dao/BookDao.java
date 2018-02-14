package com.spring.dao;

import java.util.List;

import com.spring.model.Book;

public interface BookDao {
 
	public void addOrEdit (Book book);
	
	public void delete(int bookId);
	
	public Book get(int bookId);
	
	public List<Book> list();
	
	public void reserve(int userId,String emailId,String bookName,String Status);
}
