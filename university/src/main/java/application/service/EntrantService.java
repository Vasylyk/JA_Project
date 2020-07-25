package application.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.EntrantRepository;
import application.domain.Entrant;

@Service
public class EntrantService {
	
	private Logger logger = LoggerFactory.getLogger(EntrantService.class);
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	public Entrant save (Entrant entrant) {
		logger.info("Create nwe entrant: "+entrant);
		return entrantRepository.save(entrant);
	}
	
	public List<Entrant> findAllEntrants (){
		logger.info("Find all entrants");
		return entrantRepository.findAll();
	}
	
	public Entrant findEntrantById (Integer id) {
		logger.info("Find entrant by id: "+id);
		return entrantRepository.findById(id).get();
	}
}
