package de.firstProject.tokenFinder.mapper;

import org.springframework.stereotype.Component;

import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.transfer.TokenTo;

@Component
public class TokenMapper {

	public TokenTo map(final Token token) {
		TokenTo tokenTo = new TokenTo();
		tokenTo.setVersion(token.getVersion());
		tokenTo.setContent(token.getContent());
		tokenTo.setApplication(token.getApplication());
		tokenTo.setUserTo(token.getUser());
		return tokenTo;
	}

}
