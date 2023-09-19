package com.learning.expensetracker.services;

import com.learning.expensetracker.domain.User;
import com.learning.expensetracker.exceptions.EtAuthException;

public interface UserService {
     
	User validateUser(String email,String password) throws EtAuthException;
	
	User registerUser(String firstName,String lastName,String email, String password) throws EtAuthException;
	
	
	
}
