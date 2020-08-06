package application;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import application.dao.EntrantRepository;
import application.dao.FacultyRegistrationRepository;
import application.dao.FacultyRepository;
import application.dao.UserRepository;
import application.domain.FacultyRegistration;
import application.domain.User;
import application.service.EntrantService;
import application.service.FacultyRegistrationService;
import application.service.FacultyService;
import application.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
class UniversityApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private FacultyRegistrationRepository facultyRegistrationRepository;
	
	@Autowired
	private FacultyRegistrationService facultyRegistrationService;
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	@Autowired
	private EntrantService entrantService;

	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));
	}

}
