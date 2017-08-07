package de.firstProject.tokenFinder.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "USERS")
public class Users {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeqGenerator")
	@SequenceGenerator(name = "UserSeqGenerator", sequenceName = "USER_SEQ")
	private Long id;

	@Version
	private int version;

	@Column(name = "USER_NAME")
	private String userName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Token> tokens;

	public void addToken(final Token token) {
		if (this.tokens == null) {
			this.tokens = new ArrayList<Token>();
		}
		token.setUser(this);
		this.tokens.add(token);
	}

	public Long getId() {
		return this.id;
	}

	public List<Token> getTokens() {
		return this.tokens;
	}

	public String getUserName() {
		return this.userName;
	}

	public int getVersion() {
		return this.version;
	}

	public void removeToken(final Token token) {
		if (this.tokens == null) {
			// throw Exception
		}
		if (!this.tokens.contains(token)) {
			// throw Exception
		}
		this.tokens.remove(token);
		token.setUser(null);
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return this.userName + "[" + this.id + "," + this.version + "]";
	}

}
