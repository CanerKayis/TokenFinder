package de.firstProject.tokenFinder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.firstProject.tokenFinder.db.entity.Application;
import de.firstProject.tokenFinder.db.entity.Environment;
import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.User;
import de.firstProject.tokenFinder.mapper.ApplicationMapper;
import de.firstProject.tokenFinder.mapper.TokenMapper;
import de.firstProject.tokenFinder.mapper.UserMapper;
import de.firstProject.tokenFinder.service.ApplicationService;
import de.firstProject.tokenFinder.service.TokenService;
import de.firstProject.tokenFinder.service.UserService;
import de.firstProject.tokenFinder.transfer.ApplicationTo;
import de.firstProject.tokenFinder.transfer.UserTo;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	UserService userService;
	@Autowired
	TokenService tokenService;
	@Autowired
	ApplicationService applicationservice;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TokenMapper tokenMapper;
	@Autowired
	private ApplicationMapper applicationMapper;

	// @RequestMapping(value =
	// "adduser/{userName}/{version}/{applicationName}/{content}", method =
	// RequestMethod.POST)
	// public UserTo createCompleteUser(final int version, final String
	// userName, final String applicationName,
	// final String content) {
	// Application application =
	// this.applicationservice.createApplication(applicationName, version);
	// Environment environment = Environment.TST;
	// Token token = this.tokenService.createToken(version, content,
	// application, environment);
	// User user = this.userService.createUserWithToken(userName, version,
	// token);
	// TokenTo tokenTo = this.tokenMapper.map(token);
	// UserTo userTo = new UserTo();
	// userTo.addToken(tokenTo);
	// userTo = this.userMapper.mapUser(user);
	// return userTo;
	// }
	//
	// /**
	// * Adds the user.
	// *
	// * @param userName
	// * the user name
	// * @return users from the userRepository
	// */
	// // // ?????-> http://localhost:8080/user/adduser/malsehen
	// @RequestMapping(value = "/user/adduser/{userName}", method =
	// RequestMethod.GET)
	// public Iterable<Users> addUser(@PathVariable final String userName) {
	// log.debug("method 'addUser' called ");
	// Users user1 = new Users(1, userName);
	// log.debug("new user " + userName + " created");
	// Token token1 = new Token(
	// "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ",
	// 3, Environment.TST);
	// log.info("token " + token1 + " created");
	// Application application1 = new Application(122, "testApplication");
	// log.info("application" + application1 + "is created");
	// user1.setToken(token1);
	// log.info(token1 + " linked to user: " + userName);
	// token1.setApplication(application1);
	// log.info(application1 + " linked to token: " + token1);
	// this.userRepository.save(user1);
	// log.info(user1 + " got saved in repository");
	// this.tokenRepository.save(token1);
	// log.info(token1 + " got saved in repository");
	// System.out.println(user1.toString());
	// return this.userRepository.findAll();
	// }

	@RequestMapping(value = "user/{userName}/token", method = RequestMethod.POST)
	public void addToken(final String userName, final ApplicationTo applicationTo, final Environment environment) {
		// user = userService.getByUserName(userName);
		List<User> user = this.userService.getUsers(userName);
		// map appTo -> app
		Application application = this.applicationMapper.mapApplicationTo(applicationTo);
		// ???map envTo -> env
		// token = tokenService.addTokenToUser(user,app, env)
		for (User user2 : user) {
			this.tokenService.addTokenToUser(user2, application, environment);

			// map token -> to
			for (Token token : user2.getTokens()) {
				this.tokenMapper.map(token);

			}
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public UserTo addUser(@RequestBody final UserTo userTo) {

		// map to -> user
		User newUser = this.userMapper.mapUserTo(userTo);
		// user = userService.create(user)
		newUser = this.userService.createUser(newUser);
		// map user -> to
		UserTo newUserTo = this.userMapper.mapUser(newUser);
		// return to
		return newUserTo;
	}

	@RequestMapping(value = "user/{userName}", method = RequestMethod.GET)
	public List<UserTo> getUser(@PathVariable final String userName) {
		// user = userService.getByUserName(userName);
		List<User> userlist = this.userService.getUsers(userName);
		List<UserTo> userToList = new ArrayList<>();
		// map user -> to
		for (User user : userlist) {
			userToList.add(this.userMapper.mapUser(user));
		}
		// return to
		return userToList;
	}

}
