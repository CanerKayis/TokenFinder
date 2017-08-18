package de.firstProject.tokenFinder.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.firstProject.tokenFinder.TokenFinderApplication;
import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.User;
import de.firstProject.tokenFinder.db.repository.UserRepository;

@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(TokenFinderApplication.class);
	@Autowired
	UserRepository userRepository;

	public User createUser(final User user) {
		User newUser = new User();
		newUser.setTokens(user.getTokens());
		newUser.setUserName(user.getUserName());
		newUser.setVersion(user.getVersion());
		return newUser;
	}

	public User createUserWithToken(final String userName, final int version, final Token token) {
		User user = new User();
		user.setUserName(userName);
		user.setVersion(version);
		user.addToken(token);
		return user;
	}

	public User getUserByID(final Long userID) {
		Optional<User> findById = this.userRepository.findById(userID);
		User user = null;
		if (findById != null) {
			user = findById.get();
		}
		return user;
	}

	public List<User> getUsers(final String userName) {
		List<User> users = this.userRepository.findByuserName(userName);
		return users;
	}

	public void save(final User user) {
		this.userRepository.save(user);
	}
}