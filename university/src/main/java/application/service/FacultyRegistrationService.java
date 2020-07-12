package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.FacultyRegistrationRepository;
import application.domain.FacultyRegistration;

@Service
public class FacultyRegistrationService {
	
	@Autowired
	private FacultyRegistrationRepository facultyRegistrationRepository;
	
	public FacultyRegistration save(FacultyRegistration facultyRegistration) {
		return facultyRegistrationRepository.save(facultyRegistration);
	}
	
	public List<FacultyRegistration> findAllFacultyRegistrations (){
		return facultyRegistrationRepository.findAll();
	}
	
	public FacultyRegistration findFucultyRegistrationById (Integer id) {
		return facultyRegistrationRepository.findById(id).get();
	}
}
