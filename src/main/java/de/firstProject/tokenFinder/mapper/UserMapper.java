package de.firstProject.tokenFinder.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.User;
import de.firstProject.tokenFinder.transfer.TokenTo;
import de.firstProject.tokenFinder.transfer.UserTo;

@Component
public class UserMapper {

	@Autowired
	private TokenMapper tokenMapper;

	public UserTo mapUser(final User user) {
		UserTo userTo = new UserTo();
		userTo.setUserName(user.getUserName());
		userTo.setVersion(user.getVersion());
		userTo.setTokens(createTokenToList(user.getTokens()));
		return userTo;
	}

	public User mapUserTo(final UserTo user) {
		User user1 = new User();
		user1.setUserName(user.getUserName());
		user1.setVersion(user.getVersion());

		return user1;
	}

	private List<Token> createTokenList(final List<TokenTo> tokens) {
		List<Token> returnList = new ArrayList<>();

		for (TokenTo tokenTo : tokens) {
			returnList.add(this.tokenMapper.map(tokenTo));
		}
		return returnList;
	}

	private List<TokenTo> createTokenToList(final List<Token> tokens) {
		List<TokenTo> returnList = new ArrayList<>();

		for (Token token : tokens) {
			returnList.add(this.tokenMapper.map(token));
		}
		return returnList;
	}

}