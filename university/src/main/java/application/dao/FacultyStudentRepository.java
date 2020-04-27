package application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import application.domain.FacultyStudent;

public interface FacultyStudentRepository extends JpaRepository<FacultyStudent, Integer> {

}
