package de.firstProject.tokenFinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.firstProject.tokenFinder.db.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// @RequestMapping(value = "/users/add", method = RequestMethod.GET)
	// public Iterable<Users> getUser() {
	// Users user = new Users(1, "TestUser");
	// this.userRepository.save(user);
	// return this.userRepository.findAll();

}
