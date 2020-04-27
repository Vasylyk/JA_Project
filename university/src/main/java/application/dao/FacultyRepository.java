package application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import application.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
