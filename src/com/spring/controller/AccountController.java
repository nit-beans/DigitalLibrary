package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.AccountDao;

import com.spring.model.Account;



@Controller
public class AccountController {
	@RequestMapping(value="/account",method=RequestMethod.GET)
	public ModelAndView booklist(HttpServletRequest request,ModelAndView model) throws IOException{
		@SuppressWarnings("resource")
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao=  (AccountDao) ctx.getBean("accountDao");
		int userId= Integer.parseInt(request.getParameter("userId"));
	    List<Account> orderlist = accountDao.list(userId);
	    model.addObject("orderlist",orderlist);
	    model.setViewName("Account");
	 
	    return model;
	 }
}
