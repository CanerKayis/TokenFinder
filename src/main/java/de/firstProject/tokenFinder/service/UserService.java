package de.firstProject.tokenFinder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.firstProject.tokenFinder.TokenFinderApplication;
import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.Users;
import de.firstProject.tokenFinder.db.repository.TokenRepository;
import de.firstProject.tokenFinder.db.repository.UserRepository;
import de.firstProject.tokenFinder.mapper.UserMapper;
import de.firstProject.tokenFinder.transfer.UserTo;

@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(TokenFinderApplication.class);
	@Autowired
	UserRepository userRepository;

	@Autowired
	TokenRepository tokenRepository;

	@Autowired
	private UserMapper userMapper;

	/**
	 * Gets the token by tokenId.
	 *
	 * @param tokenId
	 *            the token id
	 * @return if found, the token. else a log "requested tokenXY not found"
	 */
	@RequestMapping(value = "token/{tokenId}", method = RequestMethod.GET)
	public Optional<Token> getToken(@PathVariable final Long tokenId) {
		log.info("request TokenId" + tokenId);
		if (this.tokenRepository.findById(tokenId).isPresent() == false) {
			log.info("requested tokenId " + tokenId + " not found");
		}
		return this.tokenRepository.findById(tokenId);
	}

	@RequestMapping(value = "user/{userName}", method = RequestMethod.GET)
	public List<UserTo> getUser(@PathVariable final String userName) {
		List<UserTo> toUsers = new ArrayList<>();
		List<Users> users = this.userRepository.findByUserName(userName);
		for (Users user : users) {
			toUsers.add(this.userMapper.map(user));
		}
		return toUsers;
	}

	public void save(final Users user) {
		this.userRepository.save(user);
	}

}