package de.firstProject.tokenFinder.transfer;

public class ApplicationTo {

	private int version;
	private String applicationName;

	public String getApplicationName() {
		return this.applicationName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setApplicationName(final String applicationName) {
		this.applicationName = applicationName;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ApplicationTo [version=" + this.version + ", applicationName=" + this.applicationName + "]";
	}

}
