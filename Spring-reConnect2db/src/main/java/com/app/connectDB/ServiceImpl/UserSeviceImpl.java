package com.app.connectDB.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.connectDB.Service.UserService;
import com.app.connectDB.UserDAO.UserDao;
import com.app.connectDB.model.User;

@Service
public class UserSeviceImpl implements UserService{
	@Autowired
	private UserDao UD;
	
	@Override
	public List<User> getAll() {
		return UD.getAll();
	}

}
