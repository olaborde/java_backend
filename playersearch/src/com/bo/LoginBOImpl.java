package com.bo;

import com.dao.LoginDAOImpl;
import com.exception.BusinessException;
import com.model.User;

public class LoginBOImpl implements LoginBO {

	@Override
	public boolean isValidUser(User user) throws BusinessException {
		boolean b = false;
		
		if(user!=null && user.getUsername()!=null && user.getPassword()!= null 
				&& user.getUsername().matches("[a-zA-Z]{3}[0-9]{7}") 
				&& user.getPassword().matches("[a-z]{4}[0-9]{4}")) {
			
			b = new LoginDAOImpl().isValidUser(user);
			
		}
		else {
			throw new BusinessException("Invalid userid or password");
		}
		return b;
	}

}
