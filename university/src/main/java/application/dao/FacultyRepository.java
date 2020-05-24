package application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.domain.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
