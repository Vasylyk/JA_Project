package application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import application.domain.Faculty;
import application.domain.FacultyName;
import application.domain.Subjects;
import application.service.FacultyService;

@Controller
public class FacultyController {
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public ModelAndView createFaculty(@Valid @ModelAttribute("faculty") Faculty faculty, BindingResult bindingResult) {
		facultyService.save(faculty);
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value ="/create-faculty", method = RequestMethod.GET)
    public ModelAndView createFaculty() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("createFaculty");
    	modelAndView.addObject("subjects", Subjects.values());
    	modelAndView.addObject("faculty", new Faculty());
    	modelAndView.addObject("facultyNames", FacultyName.values());
    
    	return modelAndView;
	}
}
