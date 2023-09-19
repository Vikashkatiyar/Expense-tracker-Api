package com.learning.expensetracker.repositories;

import com.learning.expensetracker.domain.User;
import com.learning.expensetracker.exceptions.EtAuthException;

public interface UserRepository {
    
	//return created userId
	Integer create(String firstName,String lastName,String email,String password) throws EtAuthException;
	
	//check email alredy exits or not
	User findByEmailAndPassword(String email,String password)throws EtAuthException;
	
	Integer getCountByEmail(String email);
	
	User findById(Integer UserId);
	
	
}
