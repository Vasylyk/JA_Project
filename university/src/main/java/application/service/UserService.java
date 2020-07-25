package application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import application.dao.UserRepository;
import application.domain.User;
import application.domain.UserRole;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(EntrantService.class);
	
	 @Autowired
	 private UserRepository userRepository;

	 @Autowired
	 private PasswordEncoder bCryptPasswordEncoder;


	    public void save(User user) {
	    	logger.info("Create new user: "+user);
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setUserRole(UserRole.USER);
	        userRepository.save(user);
	    }
	    
	    public User findUserByEmail (String email) {
	    	logger.info("Find user by email: "+ email);
	    	return userRepository.findByEmail(email).get();
	    }
}
