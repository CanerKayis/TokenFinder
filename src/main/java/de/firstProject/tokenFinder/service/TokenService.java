package de.firstProject.tokenFinder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.firstProject.tokenFinder.db.entity.Application;
import de.firstProject.tokenFinder.db.entity.Environment;
import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.User;
import de.firstProject.tokenFinder.db.repository.TokenRepository;

@Service
public class TokenService {

	@Autowired
	TokenRepository tokenRepository;

	public Token addTokenToUser(final User user, final Application application, final Environment environment) {
		Token token = new Token();
		token.setApplication(application);
		token.setEnvironment(environment);
		user.addToken(token);
		this.tokenRepository.save(token);
		return token;
	}

	public Token createToken(final int version, final String content, final Application application,
			final Environment environment) {
		Token token = new Token();
		token.setApplication(application);
		token.setEnvironment(environment);
		token.setContent(content);
		token.setVersion(version);
		return token;
	}

	public Optional<Token> getToken(final Long tokenId) {
		if (this.tokenRepository.findById(tokenId).isPresent() == false) {
		}
		return this.tokenRepository.findById(tokenId);
	}

}
