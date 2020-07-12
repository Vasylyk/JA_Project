package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import application.dao.UserRepository;
import application.domain.User;
import application.domain.UserRole;

@Service
public class UserService {
	 @Autowired
	 private UserRepository userRepository;

	 @Autowired
	 private PasswordEncoder bCryptPasswordEncoder;


	    public void save(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setUserRole(UserRole.USER);
	        userRepository.save(user);
	    }
	    
	    public User findUserByEmail (String email) {
	    	return userRepository.findByEmail(email).get();
	    }
}
