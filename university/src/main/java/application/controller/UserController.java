package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import application.domain.Faculty;
import application.domain.Subjects;
import application.domain.User;
import application.service.FacultyService;
import application.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	 @RequestMapping(value = "/registration", method = RequestMethod.GET)
	 public String registration(Model model) {
	        model.addAttribute("userForm", new User());
	        return "registration";
	 }
	 
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
	 public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

	    if (bindingResult.hasErrors()) {
	        return "registration";
	    }
	    userService.save(userForm);
	    return "redirect:/home";
	 }
	 
	 @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	 public String login(Model model, String error, String logout) {
	    if (error != null)
	        model.addAttribute("error", "Your username and password is invalid.");

	    if (logout != null)
	        model.addAttribute("logout", "You have been logged out successfully.");

	    return "login";
	 }
	 
	 @RequestMapping(value ="/home", method = RequestMethod.GET)
	 public String welcome(Model model) {
	     return "home";
	 }
	 
	 @RequestMapping(value ="/create-faculty", method = RequestMethod.GET)
	    public ModelAndView createFaculty() {
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("createFaculty");
	    	modelAndView.addObject("subjects", Subjects.values());
	    	modelAndView.addObject("faculty", new Faculty());
	    
	    	return modelAndView;
	 }
}
