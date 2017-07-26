package de.firstProject.tokenFinder.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.firstProject.tokenFinder.TokenFinderApplication;
import de.firstProject.tokenFinder.db.entity.Application;
import de.firstProject.tokenFinder.db.entity.Environment;
import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.Users;
import de.firstProject.tokenFinder.db.repository.TokenRepository;
import de.firstProject.tokenFinder.db.repository.UserRepository;
import de.firstProject.tokenFinder.service.UserService;

@org.springframework.web.bind.annotation.RestController

public class RestController {
	private static final Logger log = LoggerFactory.getLogger(TokenFinderApplication.class);

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
		Token token1 = new Token(
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ",
				3, Environment.TST);
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
		Token token = new Token(
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ",
				1, Environment.DEV);
		this.tokenRepository.save(token);
		System.out.println(token.toString() + "wurde erstellt/gepseichert");

	}

	// // ?????-> http://localhost:8080/user/adduser/malsehen
	@RequestMapping(value = "/user/adduser/{userName}", method = RequestMethod.GET)
	public Iterable<Users> addUser(@PathVariable final String userName) {
		log.debug("method 'addUser' called ");
		Users user1 = new Users(1, userName);
		log.debug("new user " + userName + " created");
		Token token1 = new Token(
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ",
				3, Environment.TST);
		log.info("token " + token1 + " created");
		Application application1 = new Application(122, "testApplication");
		log.info("application" + application1 + "is created");
		user1.setToken(token1);
		log.info(token1 + " linked to user: " + userName);
		token1.setApplication(application1);
		log.info(application1 + " linked to token: " + token1);
		this.userRepository.save(user1);
		log.info(user1 + " got saved in repository");
		this.tokenRepository.save(token1);
		log.info(token1 + "  got saved in repository");
		System.out.println(user1.toString());
		return this.userRepository.findAll();
	}

	@RequestMapping(value = "getbytokenid/{tokenId}", method = RequestMethod.GET)
	public Optional<Token> getToken(@PathVariable final Long tokenId) {
		log.debug("request TokenId" + tokenId);
		if (this.tokenRepository.findById(tokenId).isPresent() == false) {
			log.debug("requested tokenId " + tokenId + " not found");
		}
		return this.tokenRepository.findById(tokenId);

	}

	@RequestMapping(value = "getbyusername/{userName}", method = RequestMethod.GET)
	public List<Users> getUser(@PathVariable final String userName) {
		return this.userRepository.findByUserName(userName);
	}

}
