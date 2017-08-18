package de.firstProject.tokenFinder.mapper;

import org.springframework.stereotype.Component;

import de.firstProject.tokenFinder.db.entity.Application;
import de.firstProject.tokenFinder.transfer.ApplicationTo;

@Component
public class ApplicationMapper {

	public ApplicationTo mapApplication(final Application application) {
		ApplicationTo applicationTo = new ApplicationTo();
		applicationTo.setApplicationName(application.getApplicationName());
		applicationTo.setVersion(application.getVersion());
		return applicationTo;
	}

	public Application mapApplicationTo(final ApplicationTo applicationTo) {
		Application application = new Application();
		application.setApplicationName(applicationTo.getApplicationName());
		application.setVersion(applicationTo.getVersion());
		return application;
	}

}
