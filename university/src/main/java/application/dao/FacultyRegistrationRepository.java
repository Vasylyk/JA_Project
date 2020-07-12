package application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.domain.FacultyRegistration;

@Repository
public interface FacultyRegistrationRepository extends JpaRepository<FacultyRegistration, Integer> {
	
}
