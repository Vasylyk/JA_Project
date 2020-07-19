package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.EntrantRepository;
import application.domain.Entrant;

@Service
public class EntrantService {
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	public Entrant save (Entrant entrant) {
		return entrantRepository.save(entrant);
	}
	
	public List<Entrant> findAllEntrants (){
		return entrantRepository.findAll();
	}
	
	public Entrant findEntrantById (Integer id) {
		return entrantRepository.findById(id).get();
	}
}
