package com.learning.expensetracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.expensetracker.domain.User;
import com.learning.expensetracker.exceptions.EtAuthException;
import com.learning.expensetracker.repositories.UserRepository;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User validateUser(String email, String password) throws EtAuthException {
		if(email!=null) {
			email=email.toLowerCase();
		}
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
		Pattern pattern =java.util.regex.Pattern.compile("^(.+)@(.+)$");
		if(email!=null) {
			email=email.toLowerCase();
		}
		
		if(!pattern.matcher(email).matches()) { //check the email format
			throw new EtAuthException("Invalid email format");
		}
		Integer count=userRepository.getCountByEmail(email);
		if(count>0) {
			throw new EtAuthException("Email already in Use");
		}
		Integer userId=userRepository.create(firstName, lastName, email, password);
		return userRepository.findById(userId);
		
	}

}
