package com.eddgarcia.webfinder.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eddgarcia.webfinder.model.User;
import com.eddgarcia.webfinder.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@RequestMapping(value={"/admin/user/{id}"}, method = RequestMethod.GET)
	public ModelAndView getUserById(@PathVariable int id){
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.addObject("user", userService.findUserById(id));
		modelAndView.setViewName("admin/userAdministration");
		return modelAndView;
	}*/
	
	@RequestMapping(value={"/admin/users"}, method = RequestMethod.GET)
	public ModelAndView userAdministration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allUsers", userService.getAllUsers());
		modelAndView.setViewName("admin/userAdministration");
		return modelAndView;
	}
	
	@GetMapping("/admin/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    User user = userService.findUserById(id);  
	    model.addAttribute("user", user);
	    return "admin/userEdit";
	}
	
	@PostMapping("/admin/update/{id}")
	public String updateUser(@PathVariable("id") long id, /*@Valid*/ User user, BindingResult result, Model model) {
		User persistedUser = userService.findUserById(id);
		/*if (result.hasErrors()) {
	      user.setId((int)id);
	      return "admin/userEdit";  
		}*/
		
		persistedUser.setName(user.getName());
		userService.saveUser(persistedUser);
		model.addAttribute("allUsers", userService.getAllUsers());
		return "admin/userAdministration";
	}
  
	@GetMapping("/admin/deactivate/{id}")
	public String deactivateUser(@PathVariable("id") long id) {
	    User user = userService.findUserById(id);
	    user.setActive(0);
	    userService.saveUser(user);    
	    return "redirect:/admin/users";
	}
	
	@GetMapping("/admin/activate/{id}")
	public String activateUser(@PathVariable("id") long id, Model model) {
	    User user = userService.findUserById(id);
	    user.setActive(1);
	    userService.saveUser(user);
	    
	    model.addAttribute("allUsers", userService.getAllUsers());
	    return "admin/userAdministration";
	}
	
	@GetMapping("/admin/adduser")
	public String showSignUpForm(User user) {
	    return "admin/userAdd";
	}
	
    @PostMapping("/admin/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/userAdd";
        }
        userService.saveUser(user);
        model.addAttribute("allUsers", userService.getAllUsers());
	    return "admin/userAdministration";
    }
    
	/*@RequestMapping(value={"/admin/users/"}, method = RequestMethod.GET)
	public ModelAndView editUser(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allUsers", userService.getAllUsers());
		modelAndView.setViewName("admin/userAdministration");
		return modelAndView;
	}*/
}
