package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.BookDao;
//import com.spring.dao.UserDao;
import com.spring.model.Book;


@Controller
public class BookController {
	
	/*ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
	BookDao bookDao= (BookDao) ctx.getBean("bookDao");*/

	@RequestMapping(value="/cat")
	public ModelAndView booklist(ModelAndView model) throws IOException{
		@SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BookDao bookDao= (BookDao) ctx.getBean("bookDao");
	    List<Book> booklist = bookDao.list();
	    model.addObject("booklist",booklist);
	    model.setViewName("CatalogAdmin");
	 
	    return model;
	 }
	
	@RequestMapping(value ="/addBook", method = RequestMethod.GET)
	public ModelAndView newBook(ModelAndView model) {
		@SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		@SuppressWarnings("unused")
		BookDao bookDao= (BookDao) ctx.getBean("bookDao");
	    Book newBook = new Book();
	    model.addObject("book", newBook);
	    model.setViewName("BookForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book) {
		@SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BookDao bookDao= (BookDao) ctx.getBean("bookDao");
	    bookDao.addOrEdit(book);
	    return new ModelAndView("redirect:/cat");
	}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		@SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BookDao bookDao= (BookDao) ctx.getBean("bookDao");
	    int bookId = Integer.parseInt(request.getParameter("Id"));
	    bookDao.delete(bookId);
	    return new ModelAndView("redirect:/cat");
	}
	
	@RequestMapping(value = "/editBook", method = RequestMethod.GET)
	public ModelAndView editBook(HttpServletRequest request) {
		@SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BookDao bookDao= (BookDao) ctx.getBean("bookDao");
	    int bookId = Integer.parseInt(request.getParameter("Id"));
	    Book book = bookDao.get(bookId);
	    ModelAndView model = new ModelAndView("BookForm");
	    model.addObject("book", book);
	 
	    return model;
	}
	
	@RequestMapping(value="/reserveBook", method=RequestMethod.GET)
	public ModelAndView reserveBook(HttpServletRequest request,HttpServletRequest request2,HttpServletRequest request3,HttpServletRequest request4,HttpServletResponse response){
		
		 ModelAndView view = new ModelAndView();
		 @SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		BookDao bookDao= (BookDao) ctx.getBean("bookDao");
		//UserDao userDao=(UserDao) ctx.getBean("UserDao");
	    String emailId= (request.getParameter("Email"));
	    String bookName = (request2.getParameter("Name"));
	    String status="reserved";
	    int userId=Integer.parseInt(request3.getParameter("userId"));
	    bookDao.reserve(userId,emailId,bookName,status);
	    //Login login=new Login();
	    request4.setAttribute("userId", userId);
	    view.setViewName("Reserve");
		return view;
	}
	
	
}
