package com.bookstore;

import com.bookstore.domain.User;
import com.bookstore.security.Role;
import com.bookstore.security.UserRole;
import com.bookstore.service.UserService;
import com.bookstore.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user = new User();
		user.setFirstName("j");
		user.setLastName("Adams");
		user.setUsername("j");
		user.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user.setEmail("JAdams@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();

		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		userRoles.add(new UserRole(user, role));

		userService.createUser(user, userRoles);
	}
}
