package de.firstProject.tokenFinder.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "APPLICATION")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ApplicationSeqGenerator")
	@SequenceGenerator(name = "ApplicationSeqGenerator", sequenceName = "APPLICATION_SEQ")
	private Long id;

	@Version
	private int version;
	private String applicationName;

	public Application() {
	}

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

}
