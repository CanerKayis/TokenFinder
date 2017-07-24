package de.firstProject.tokenFinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.firstProject.tokenFinder.db.entity.Application;
import de.firstProject.tokenFinder.db.entity.Environment;
import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.Users;
import de.firstProject.tokenFinder.db.repository.TokenRepository;
import de.firstProject.tokenFinder.db.repository.UserRepository;
import de.firstProject.tokenFinder.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TokenRepository tokenRepository;

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public Iterable<Users> add() {
		Users user = new Users();
		user.setUserName("testUser");
		user.setVersion(22);
		this.userRepository.save(user);
		System.out.println(user);
		return this.userRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Iterable<Users> addAll() {
		Users user1 = new Users(12, "testUser+token");
		Token token1 = new Token(3, Environment.TST);
		Application application1 = new Application(122, "testApplication");
		user1.setToken(token1);
		token1.setApplication(application1);
		this.userRepository.save(user1);
		this.tokenRepository.save(token1);

		System.out.println(user1);
		return this.userRepository.findAll();
	}

	@RequestMapping(value = "/user/addrandom", method = RequestMethod.GET)
	public Iterable<Users> addRandomUser() {
		Users user = new Users(2, "TestUserW/O-Token");
		this.userRepository.save(user);
		System.out.println(user);
		return this.userRepository.findAll();
	}

	@RequestMapping(value = "/token/randomtoken", method = RequestMethod.GET)
	public void addtoken() {
		Token token = new Token(1, Environment.DEV);
		this.tokenRepository.save(token);
		System.out.println(token.toString() + "wurde erstellt/gepseichert");

	}

	// // ?????-> http://localhost:8080/user/adduser?userName=malsehen
	// @RequestMapping(value = "/user/adduser", method = RequestMethod.GET)
	// public Iterable<Users> addUser(@PathVariable final String userName1) {
	// Users user = new Users(1, userName1);
	// this.userRepository.save(user);
	// System.out.println(user.toString());
	// return this.userRepository.findAll();
	// }
}
