package de.firstProject.tokenFinder.service;

import org.springframework.stereotype.Service;

import de.firstProject.tokenFinder.db.entity.Application;
import de.firstProject.tokenFinder.db.entity.Token;

@Service
public class ApplicationService {

	public void addApplicationToToken(final Application application, final Token token) {
		token.setApplication(application);
	}

	public Application createApplication(final String applicationName, final int version) {
		Application application = new Application();
		application.setApplicationName(applicationName);
		application.setVersion(version);
		return application;

	}
}