package com.app.connectDB.UserDAOImpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.app.connectDB.UserDAO.UserDao;
import com.app.connectDB.model.User;

@Repository
@Transactional
@EnableTransactionManagement
//@Configuration
public class UserDaoImpl implements UserDao {
	private static final String URL = "jdbc:mysql://localhost:3306/dataadmin";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	@Autowired
	private SessionFactory sf;

	@Override
	public List<User> getAll() {
		
		Connection connection;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			DatabaseMetaData metadata = connection.getMetaData();
			ResultSet resultSet;
			resultSet = metadata.getTables(null, null, "User", null);
			if(resultSet.next() == false){
				   // next() checks if the next table exists ...
				      System.out.println("Table not exists");
				      return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Session s = sf.getCurrentSession();
		Query qr = s.createQuery("from User");
		List<User> listResult = qr.list();
		s.flush();
		return listResult;
	}

}
