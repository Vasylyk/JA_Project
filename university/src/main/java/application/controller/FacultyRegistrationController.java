package application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import application.domain.Faculty;
import application.domain.FacultyRegistration;
import application.domain.User;
import application.service.FacultyRegistrationService;
import application.service.FacultyService;
import application.service.UserService;

@Controller
public class FacultyRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private FacultyRegistrationService facultyRegistrationService;
	
	@RequestMapping(value = "/faculties", method = RequestMethod.GET)
	public ModelAndView faculties() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("faculties");
		modelAndView.addObject("faculties", facultyService.findAllFaculties());
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/faculty-registration", method = RequestMethod.GET)
	public ModelAndView facultyRegistration(@RequestParam("currentFacultyId") Integer currentFacultyId, @RequestParam("currentUserEmail") String currentUserEmail) {
		User user = userService.findUserByEmail(currentUserEmail);
		Faculty faculty = facultyService.findFacultyById(currentFacultyId);
		
		FacultyRegistration fr = new FacultyRegistration();
		fr.setFaculty(faculty);
		fr.setUser(user);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("facultyRegistration");
		modelAndView.addObject("fr", fr);
		return modelAndView;
	}
	
	@RequestMapping(value = "/addMarks", method = RequestMethod.POST)
	public ModelAndView registration(@Valid @ModelAttribute("fr") FacultyRegistration facultyRegistration, BindingResult bindingResult) {
		Faculty faculty = facultyService.findFacultyById(facultyRegistration.getFacultyId());
		User user = userService.findUserByEmail(facultyRegistration.getUserEmail());

		facultyRegistration.setUser(user);
		facultyRegistration.setFaculty(faculty);
		facultyRegistrationService.save(facultyRegistration);

		return new ModelAndView("redirect:/home");
	}
}
