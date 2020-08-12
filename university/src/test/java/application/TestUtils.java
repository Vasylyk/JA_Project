package application;

import application.domain.Entrant;
import application.domain.Faculty;
import application.domain.FacultyName;
import application.domain.FacultyRegistration;
import application.domain.Subjects;
import application.domain.User;
import application.domain.UserRole;

public class TestUtils {
	
	public static User createUser() {
		User user = new User("email", "password", "firstName", "lastName", UserRole.USER);
		return user;
	}
	
	public static Faculty createFaculty() {
		Faculty faculty = new Faculty();
		faculty.setFacultyName(FacultyName.DIPLOMACY);
		faculty.setFirstSubject(Subjects.FOREIGN_LANGUAGE);
		faculty.setSecondSubject(Subjects.GEOGRAPHY);
		faculty.setThirdSubject(Subjects.HISTORY);
		faculty.setNumberOfStudents(100);
		return faculty;
	}
	
	public static FacultyRegistration createFacultyRegistration () {
		FacultyRegistration facultyRegistration = new FacultyRegistration();
		facultyRegistration.setUser(new User(1,"email", "password", "firstName", "lastName", UserRole.USER));
		facultyRegistration.setFaculty(new Faculty(2, 100, FacultyName.DIPLOMACY, Subjects.FOREIGN_LANGUAGE, Subjects.FOREIGN_LANGUAGE, Subjects.FOREIGN_LANGUAGE));
		facultyRegistration.setFirstSubjectMark(100);
		facultyRegistration.setSecondSubjectMark(100);
		facultyRegistration.setThirdSubjectMark(100);
		return facultyRegistration;
	}
	
	public static Entrant createEntrant() {
		Entrant entrant = new Entrant();
		entrant.setUser(new User(3,"email", "password", "firstName", "lastName", UserRole.USER));
		entrant.setFaculty(new Faculty(4, 100, FacultyName.DIPLOMACY, Subjects.FOREIGN_LANGUAGE, Subjects.FOREIGN_LANGUAGE, Subjects.FOREIGN_LANGUAGE));
		entrant.setFirstSubjectMark(100);
		entrant.setSecondSubjectMark(100);
		entrant.setThirdSubjectMark(100);
		return entrant;
	}
}
