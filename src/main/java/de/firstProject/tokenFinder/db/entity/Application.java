package de.firstProject.tokenFinder.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION")
public class Application {

	@Id
	// @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int version;
	private String applicationName;

	public Application() {
	}

	// public Application(final int version, final String applicationName) {
	// super();
	// this.version = version;
	// this.applicationName = applicationName;
	// }

	public String getApplicationName() {
		return this.applicationName;
	}

	public Long getId() {
		return this.id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setApplicationName(final String applicationName) {
		this.applicationName = applicationName;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

}
