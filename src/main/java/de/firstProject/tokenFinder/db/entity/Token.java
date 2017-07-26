package de.firstProject.tokenFinder.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TOKEN")
public class Token {

	// @Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int version;
	private String content;

	private Environment environment; // Serverumgebung

	// @Column(name = "id")
	// @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// private final List<Users> userList = new ArrayList<>();

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Application application;

	public Token() {
	}

	public Token(final String content, final int version, final Environment environment) {
		super();
		this.content = content;
		this.version = version;
		this.environment = environment;
	}

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

	// @Column(name = "USER_ID")
	// public List<Users> getUserList() {
	// return this.userList;
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

	@Override
	public String toString() {
		return "Token [id=" + this.id + ", version=" + this.version + ", environment=" + this.environment
				+ ", application=" + this.application + "]";
	}

}
