package com.bo;



import com.dao.UserRegistrationDAO;
import com.dao.UserRegistrationDAOImpl;
import com.exception.BusinessException;
import com.model.User;

public class UserRegistrationBOImpl implements UserRegistrationBO {
	
	private UserRegistrationDAO userRegistrationDAO;

	@Override
	public User addUser(User user) throws BusinessException {

		
		if(user!=null && user.getUsername()!=null && user.getPassword()!= null 
				&& user.getUsername().matches("[a-zA-Z]{3}[0-9]{7}") 
				&& user.getPassword().matches("[a-z]{4}[0-9]{4}")) {
			userRegistrationDAO = getUserRegistrationDAO();
			user = userRegistrationDAO.addUser(user);
			
			System.out.println("out of ---> adduser from useregreistrationBO IMpl ");
		}
		
		return user;
	}
	
	
	private UserRegistrationDAO getUserRegistrationDAO() {
		if(userRegistrationDAO==null) {
			userRegistrationDAO = new UserRegistrationDAOImpl();
		}
		return userRegistrationDAO;
	}

}
