package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.modal.User;
import com.example.repository.App1Repository;

@RestController
public class App1Controller {

	@Autowired
	App1Repository app1Repository;

	@ResponseBody
	@RequestMapping("/home")
	public String hello() {
		return "Hello i am spring!!";
	}
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public List<User> getAllUser() {

		// return back to index.jsp
		ModelAndView model = new ModelAndView("viewUsers");
		List<User> viewUser = app1Repository.getAllUsers();
		return viewUser;
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {

		// return back to index.jsp
		ModelAndView model = new ModelAndView("viewUsers");
		List<User> viewUser = app1Repository.getAllUsers();
		model.addObject("data", viewUser);
		return model;
	}

	@RequestMapping(value = "/deleteUser")
	public ModelAndView deteteUser(@RequestParam("id") int userId) {
		int user = app1Repository.deleteUser(userId);
		ModelAndView mv = new ModelAndView();
		if(user>0)
		{
			List<User> viewUser = app1Repository.getAllUsers();
			mv.addObject("data", viewUser);
			mv.setViewName("viewUsers");
			return mv;
		}
		else
		{
			mv.setViewName("ErrorPage");
		return mv;
		}
	}

	

	@GetMapping("/create")
	public  ModelAndView createPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("create");
		return mv;
	}
	@RequestMapping(value="/createation",method=RequestMethod.POST)
	public ModelAndView doCreate(Model model,User user)
	{
		System.out.println("controller"+user);
		 int x = app1Repository.UserCreation(user);
		 ModelAndView mv = new ModelAndView();
		 if(x>0)
		 {
			 mv.setViewName("login");
			return mv;
		 }
		 else
		 {
			 mv.setViewName("Error");
			 return mv;
		 }
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam("id") int userId) {
		List<User> user = app1Repository.editUser(userId);
		ModelAndView mv = new ModelAndView("editUser");
		mv.addObject("user", user);
		return mv;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
    public ModelAndView updateUser(Model model,User user)
    {
		int updateUser= app1Repository.updateUser(user);
		ModelAndView mv = new ModelAndView();
		if(updateUser >0)
		{	
			
			List<User> viewUser = app1Repository.getAllUsers();
			mv.addObject("data", viewUser);
			mv.setViewName("viewUsers");
			return mv;
		}
		else
		{
			mv.setViewName("ErrorUpdate");
			return mv;
		}
    }
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView login(User user)
	{
     	List<User> users = app1Repository.login(user);
	
		ModelAndView mv = new ModelAndView();
        if(users != null)
        {
		mv.setViewName("login");
		return mv;
        }
        else
        {
        mv.setViewName("ErrorPage");
        return mv;
        }
	}
	
}
