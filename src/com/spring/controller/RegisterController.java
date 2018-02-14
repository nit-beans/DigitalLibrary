package com.spring.controller;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.UserDao;
import com.spring.model.User;

@Controller
public class RegisterController {
	
	 //private UserDao userDao;
	 
	 @RequestMapping(value = "/register")
	 public ModelAndView register(@ModelAttribute(value="User")User user){
		 @SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		 UserDao userDao = (UserDao) ctx.getBean("userDao");
		 userDao.register(user);
		 return new ModelAndView("ResultPage","message","Registered successfully");
		 
	 }
}
