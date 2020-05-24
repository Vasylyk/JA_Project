package application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.domain.FacultyStudent;

@Repository
public interface FacultyStudentRepository extends JpaRepository<FacultyStudent, Integer> {

}
