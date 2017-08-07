package de.firstProject.tokenFinder.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Users user;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Application application;

	public Application getApplication() {
		return this.application;
	}

	public String getContent() {
		return this.content;
	}

	public Long getId() {
		return this.id;
	}

	public Users getUser() {
		return this.user;
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

	public void setUser(final Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Token [id=" + this.id + ", version=" + this.version + ", application=" + this.application + "]";
	}

}
