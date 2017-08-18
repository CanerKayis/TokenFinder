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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "USERS")
public class User {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeqGenerator")
	@SequenceGenerator(name = "UserSeqGenerator", sequenceName = "USER_SEQ")
	private Long id;

	@Version
	private int version;

	@Column(name = "username")
	private String userName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Token> tokens = new ArrayList<Token>();

	public void addToken(final Token token) {
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
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setTokens(final List<Token> tokens) {
		this.tokens = tokens;
	}

	public void setUserName(final String name) {
		this.userName = name;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return this.userName + "[" + this.id + "," + this.getVersion() + "]";
	}

}
