package de.firstProject.tokenFinder.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.Users;
import de.firstProject.tokenFinder.transfer.TokenTo;
import de.firstProject.tokenFinder.transfer.UserTo;

@Component
public class UserMapper {

	private TokenMapper tokenMapper;

	public UserTo map(final Users user) {
		UserTo userTo = new UserTo();
		userTo.setUserName(user.getUserName());
		userTo.setVersion(user.getVersion());
		userTo.setTokens((createTokenToList(user.getTokens())));
		return userTo;
	}

	private List<TokenTo> createTokenToList(final List<Token> tokens) {
		ArrayList<TokenTo> returnList = new ArrayList<>();
		for (Token token : tokens) {
			returnList.add(this.tokenMapper.map(token));
		}
		return returnList;
	}

}
