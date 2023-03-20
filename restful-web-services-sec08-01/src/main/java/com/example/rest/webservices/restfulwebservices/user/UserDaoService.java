package com.example.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.example.rest.webservices.restfulwebservices.user.domain.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int coutUsers = 0;
	
	static {
		users.add(new User(++coutUsers,"fuad", LocalDate.now().minusYears(26)));
		users.add(new User(++coutUsers,"fahmida", LocalDate.now().minusYears(16)));
		users.add(new User(++coutUsers,"jarif", LocalDate.now().minusYears(2))); 
	}
	
	public List<User> findAll() {
		return users;
	}

	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++coutUsers);
		users.add(user);
		return user;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		users.removeIf(user -> user.getId() == id);
		
	}
}
