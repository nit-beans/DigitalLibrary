package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.spring.dao.BookDao;
import com.spring.dao.LoginDao;

import com.spring.model.Book;
import com.spring.model.Login;


@Controller
public class LoginController {
	
	 @RequestMapping(value = "/login")
	 public ModelAndView login(HttpServletRequest request,HttpServletResponse response,@ModelAttribute(value="Login")Login login){
		 ModelAndView view = new ModelAndView();
		 @SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		 LoginDao loginDao = (LoginDao) ctx.getBean("loginDao");
		
		
		
		 if(loginDao.authenticate(login)){
			 BookDao bookDao= (BookDao) ctx.getBean("bookDao");
			    List<Book> booklist = bookDao.list();
			    view.addObject("booklist",booklist);
			    request.setAttribute("activeUser", login.getEmailId());
			    request.setAttribute("userId", loginDao.getId(login));
			 view.setViewName("CatalogUser");
		 }
		 else if(loginDao.adminLogin(login)){
			 BookDao bookDao= (BookDao) ctx.getBean("bookDao");
			    List<Book> booklist = bookDao.list();
			    view.addObject("booklist",booklist);
			    request.setAttribute("activeUser", "admin");
			    
			 view.setViewName("CatalogAdmin");
		}
		 else if(!loginDao.authenticate(login) || !loginDao.adminLogin(login)){
			 view.setViewName("error");
			 }
         return view;
	 }
	 
}