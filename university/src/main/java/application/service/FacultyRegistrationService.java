package application.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.FacultyRegistrationRepository;
import application.domain.FacultyRegistration;

@Service
public class FacultyRegistrationService {
	
	private Logger logger = LoggerFactory.getLogger(EntrantService.class);
	
	@Autowired
	private FacultyRegistrationRepository facultyRegistrationRepository;
	
	public FacultyRegistration save(FacultyRegistration facultyRegistration) {
		logger.info("Create new facultyRegistration: "+facultyRegistration);
		return facultyRegistrationRepository.save(facultyRegistration);
	}
	
	public List<FacultyRegistration> findAllFacultyRegistrations (){
		logger.info("Find all facultyRegistrations");
		return facultyRegistrationRepository.findAll();
	}
	
	public FacultyRegistration findFucultyRegistrationById (Integer id) {
		logger.info("Find facultyRegistration by id: "+id);
		return facultyRegistrationRepository.findById(id).get();
	}
	
	public void deleteFacultyRegistrationById (Integer id) {
		logger.info("Delete facultyRegistration by id: "+id);
		facultyRegistrationRepository.deleteById(id);
	}
}
