package application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.domain.Entrant;

@Repository
public interface EntrantRepository extends JpaRepository<Entrant, Integer> {

}
