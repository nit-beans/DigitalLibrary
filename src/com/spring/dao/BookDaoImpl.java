package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Book;

public class BookDaoImpl implements BookDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	@Override
	public void addOrEdit(Book book) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		if (book.getId() > 0) {
	        // edit
	        String sql = "UPDATE book SET BookName=?, BookAuthor=?, BookCategory=?, "
	                    + "BookISBN=? WHERE BookId=?";
	        jdbcTemplate.update(sql, book.getBookName(),book.getBookAuthor()
	        		,book.getBookCategory(),book.getBookISBN(),book.getId());
	    } else {
	        // add
	        String sql = "INSERT INTO book (BookName,  BookAuthor, BookCategory, BookISBN)"
	                    + " VALUES (?, ?, ?, ?)";
	        jdbcTemplate.update(sql, book.getBookName(),book.getBookAuthor()
	        		,book.getBookCategory(),book.getBookISBN());
	    }
	 
		
	}

	@Override
	public void delete(int bookId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM book WHERE BookId=?";
	    jdbcTemplate.update(sql, bookId);
	}

	@Override
	public Book get(int bookId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM book WHERE BookId=" + bookId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Book>() {
	 
	        @Override
	        public Book extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Book book = new Book();
	                book.setId(rs.getInt("BookId"));
	                book.setBookName(rs.getString("BookName"));
	                book.setBookAuthor(rs.getString("BookAuthor"));
	                book.setBookCategory(rs.getString("BookCategory"));
	                book.setBookISBN(rs.getInt("BookISBN"));
	                return book;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Book> list() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 String sql = "SELECT * FROM book";
		    List<Book> booklist = jdbcTemplate.query(sql, new RowMapper<Book>() {
		 
		        @Override
		        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Book aBook = new Book();
		 
		            aBook.setId(rs.getInt("BookId"));
		            aBook.setBookName(rs.getString("BookName"));
		            aBook.setBookAuthor(rs.getString("BookAuthor"));
		            aBook.setBookCategory(rs.getString("BookCategory"));
		            aBook.setBookISBN(rs.getInt("BookISBN"));
		 
		            return aBook;
		        }
		 
		    });
		 
		    return booklist;
	}
	@Override
	public void reserve(int userId,String emailId,String bookName, String Status) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "Insert into orders(userId,emailId,BookName,Status) values (?,?,?,?)";
	    jdbcTemplate.update(sql, userId,emailId,bookName,Status);
		
	}
	
	
}
