package de.firstProject.tokenFinder.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "TOKEN")
public class Token {

	// @Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TokenSeqGenerator")
	@SequenceGenerator(name = "TokenSeqGenerator", sequenceName = "TOKEN_SEQ")
	private Long id;
	@Version
	private int version;

	@Column(name = "CONTENT")
	private String content;

	@Enumerated(EnumType.STRING)
	public Environment environment;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Application application;

	public Application getApplication() {
		return this.application;
	}

	public String getContent() {
		return this.content;
	}

	public Environment getEnvironment() {
		return this.environment;
	}

	public Long getId() {
		return this.id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setApplication(final Application application) {
		this.application = application;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	// public Users getUser() {
	// return this.user;
	// }

	public void setEnvironment(final Environment environment) {
		this.environment = environment;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	// public void setUser(final Users user) {
	// this.user = user;
	// }

	@Override
	public String toString() {
		return "Token [id=" + this.id + ", version=" + this.version + ", application=" + this.application + "]";
	}

}
