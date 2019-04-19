package com.bo;

import com.exception.BusinessException;
import com.model.User;

public interface UserRegistrationBO {
	
	public User addUser(User user) throws BusinessException;

}
