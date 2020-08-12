package application;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import application.domain.Entrant;
import application.domain.Faculty;
import application.domain.FacultyRegistration;
import application.domain.User;
import application.service.EntrantService;
import application.service.FacultyRegistrationService;
import application.service.FacultyService;
import application.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
@Transactional
class UniversityApplicationTests {
		
	@Autowired
	private UserService userService;
		
	@Autowired
	private FacultyService facultyService;
		
	@Autowired
	private FacultyRegistrationService facultyRegistrationService;
	
	@Autowired
	private EntrantService entrantService;

	@Test
	public void testSaveAndFindByEmailUser() {
		User user = TestUtils.createUser();
		userService.save(user);
		User userFromDB = userService.findUserByEmail(user.getEmail());
		//userService.deleteById(userFromDB.getId());
		assertTrue(userFromDB.getEmail().equals(user.getEmail()));
		assertTrue(userFromDB.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDB.getLastName().equals(user.getLastName()));	
	}
	
	@Test
	public void testSaveAndFindByIdFaculty() {
		Faculty faculty = TestUtils.createFaculty();
		Faculty save = facultyService.save(faculty);
		Faculty facultyFromDB = facultyService.findFacultyById(save.getId());
		assertTrue(facultyFromDB.getId().equals(save.getId()));	
	}
	
	@Test
	public void testFindAllFaculty() {
		Faculty faculty = TestUtils.createFaculty();
		facultyService.save(faculty);
		List <Faculty> faculties = facultyService.findAllFaculties();
		assertNotNull(faculties);
	}
	
	@Test
	public void testSaveAndFindByIdFacultyRegistration() {
		FacultyRegistration facultyRegistration = TestUtils.createFacultyRegistration();
		FacultyRegistration save = facultyRegistrationService.save(facultyRegistration);
		FacultyRegistration facultyRegistrationFromDB = facultyRegistrationService.findFucultyRegistrationById(save.getId());
		assertTrue(facultyRegistrationFromDB.getId().equals(save.getId()));
	}
	
	@Test
	public void testFindAllFacultyRegistration() {
		FacultyRegistration facultyRegistration = TestUtils.createFacultyRegistration();
		facultyRegistrationService.save(facultyRegistration);
		List <FacultyRegistration> facultyRegistrations = facultyRegistrationService.findAllFacultyRegistrations();
		assertNotNull(facultyRegistrations);
	}
	
	@Test
	public void testDeleteFacultyRegistrationById() throws NoSuchElementException{
		FacultyRegistration facultyRegistration = TestUtils.createFacultyRegistration();
		FacultyRegistration save = facultyRegistrationService.save(facultyRegistration);
		assertNotNull(save);
		facultyRegistrationService.deleteFacultyRegistrationById(save.getId());	
		Throwable thrown = catchThrowable(() -> {
			facultyRegistrationService.findFucultyRegistrationById(save.getId());
		});
		assertThat(thrown).isInstanceOf(NoSuchElementException.class);	
	}
	
	@Test
	public void testSaveandFindByIdEntrant() {
		Entrant entrant = TestUtils.createEntrant();
		Entrant save = entrantService.save(entrant);
		Entrant entrantFromDB = entrantService.findEntrantById(save.getId());
		assertTrue(save.getId().equals(entrantFromDB.getId()));
	}
	
	@Test
	public void testFindAllEntrants() {
		Entrant entrant = TestUtils.createEntrant();
		entrantService.save(entrant);
		List<Entrant> entrants = entrantService.findAllEntrants();
		assertNotNull(entrants);
		
	}
	
}
