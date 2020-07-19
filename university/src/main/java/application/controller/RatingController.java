package application.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import application.domain.Entrant;
import application.domain.Faculty;
import application.service.EntrantService;
import application.service.FacultyService;

@Controller
public class RatingController {
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private EntrantService entrantService;
	
	@RequestMapping(value = "/ratingFaculties", method = RequestMethod.GET )
	public ModelAndView rating () {
		ModelAndView modelAndView = new ModelAndView("ratingFaculties");
		modelAndView.addObject("faculties", facultyService.findAllFaculties());
		return modelAndView;
	}
	
	@RequestMapping(value = "/rating", method = RequestMethod.GET)
	public ModelAndView facultyRegistration(@RequestParam("currentFacultyId") Integer currentFacultyId) {
		List<Entrant> listOfAllEntrants = entrantService.findAllEntrants();
		Faculty currentFaculty = facultyService.findFacultyById(currentFacultyId);
		List <Entrant> entrantsOfCurrentFaculty = new ArrayList<Entrant>();
		for (Entrant entrant : listOfAllEntrants) {
			if (entrant.getFaculty().equals(currentFaculty)) {
				entrantsOfCurrentFaculty.add(entrant);
			}
		}
		Collections.sort(entrantsOfCurrentFaculty);
		
		List<String> isAccepted = new ArrayList<String>();
		for (int i = 0; i < entrantsOfCurrentFaculty.size(); i++) {
			if (i<currentFaculty.getNumberOfStudents()) {
				isAccepted.add("Accepted");
			} else {
				isAccepted.add("Rejected");
			}
		}
		
		ModelAndView modelAndView = new ModelAndView("rating");
		modelAndView.addObject("currentFaculty", currentFaculty);
		modelAndView.addObject("entrantsOfCurrentFaculty", entrantsOfCurrentFaculty);
		modelAndView.addObject("isAccepted", isAccepted);
		return modelAndView;
	}
}
