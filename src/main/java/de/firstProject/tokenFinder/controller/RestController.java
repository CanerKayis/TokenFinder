package de.firstProject.tokenFinder.controller;

import org.springframework.beans.factory.annotation.Autowired;

import de.firstProject.tokenFinder.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	UserService userService;

	// @RequestMapping(value = "/user/try", method = RequestMethod.GET)
	// public Iterable<Users> addUser() {
	// return this.userService.getUser();
	// }
}
