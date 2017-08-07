package de.firstProject.tokenFinder.transfer;

import de.firstProject.tokenFinder.db.entity.Application;
import de.firstProject.tokenFinder.db.entity.Users;

public class TokenTo {
	private int version;

	private String content;

	private Users user;

	private Application application;

	public Application getApplication() {
		return this.application;
	}

	public String getContent() {
		return this.content;
	}

	public Users getUserTo() {
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

	public void setUserTo(final Users user) {
		this.user = this.user;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Token [id=" + ", version=" + this.version + ", application=" + this.application + "]";
	}

}
