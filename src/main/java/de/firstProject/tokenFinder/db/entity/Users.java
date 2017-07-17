package de.firstProject.tokenFinder.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {

	// @Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int version;
	private String userName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Token token;

	public Users() {
	}

	public Users(final int version, final String userName) {
		super();
		this.version = version;
		this.userName = userName;
	}

	public Long getId() {
		return this.id;
	}

	public Token getToken() {
		return this.token;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return this.userName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setToken(final Token token) {
		this.token = token;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

}
