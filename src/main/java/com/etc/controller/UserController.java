package com.etc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.etc.entity.Users;
import com.etc.service.UserService;

/**
 * 控制层
 * @author Administrator
 * @Version
 */
@Controller
public class UserController {
    @Autowired
	UserService userService;
    
	@RequestMapping("/register")
	public String register(String username,String userpwd){
		//调用service层
		boolean flag = userService.addUser(username, userpwd);
		if (flag) {
			
			return "success";
		}
		return "fail";
		

	}
	
	@RequestMapping("/queryAllUser")
	public ModelAndView queryAllUser(){
		
		ModelAndView mv = new ModelAndView();
		List<Users> list=userService.queryAllUser();
		
		mv.addObject("list", list);
		
		mv.setViewName("showUser");
			
		return mv;
	}
	
	@RequestMapping(value = "/queryLike", method = RequestMethod.GET)
	public ModelAndView queryLikeNameByPage( HttpServletRequest request,String name){
		ModelAndView mv = new ModelAndView();
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("pageNo"));
		int  No = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = 4;
		
		List<Users> list=userService.queryLikeNameByPage(No,pageSize, name);
	
		mv.addObject("list",list);
		mv.setViewName("showUser");
		return mv;
		
		
		
	}
	
}
