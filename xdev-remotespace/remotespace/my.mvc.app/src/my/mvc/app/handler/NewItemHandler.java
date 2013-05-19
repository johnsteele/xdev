package my.mvc.app.handler;

import my.mvc.app.controller.ListViewController;

import org.eclipse.e4.core.contexts.Active;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;

@SuppressWarnings("restriction")
public class NewItemHandler {
	@CanExecute
	public boolean isEnabled(@Active @Optional ListViewController<?> controller) {
		return controller != null;
	}
	
	@Execute
	public void createItem(@Active ListViewController<?> controller) {
		controller.createNewObject();
	}
}
