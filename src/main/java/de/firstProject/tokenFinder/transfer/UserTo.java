package de.firstProject.tokenFinder.transfer;

import java.util.ArrayList;
import java.util.List;

public class UserTo {

	private int version;

	private String userName;

	private List<TokenTo> tokens;

	public void addToken(final TokenTo token) {
		if (this.getTokens() == null) {
			this.setTokens(new ArrayList<TokenTo>());
		}
		token.setUserTo(token.getUserTo());
		this.getTokens().add(token);
	}

	public List<TokenTo> getTokens() {
		return this.tokens;
	}

	public String getUserName() {
		return this.userName;
	}

	public int getVersion() {
		return this.version;
	}

	public void removeToken(final TokenTo token) {
		if (this.getTokens() == null) {
			// throw Exception
		}
		if (!this.getTokens().contains(token)) {
			// throw Exception
		}
		this.getTokens().remove(token);
		token.setUserTo(null);
	}

	public void setTokens(final List<TokenTo> tokens) {
		this.tokens = tokens;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public void setVersion(final int version) {
		this.version = version;
		// this.setVersion(version);
	}

	@Override
	public String toString() {
		return this.userName + "[" + this.version + "]";
	}
}
