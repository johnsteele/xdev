package my.mvc.app.controller.e4;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import my.mvc.app.controller.PersonViewController;
import my.mvc.app.model.ModelFactory;
import my.mvc.app.model.Person;

@SuppressWarnings("restriction")
public class PersonViewControllerImpl implements PersonViewController {
	private ObservableList<Person> personList = FXCollections.observableArrayList();
	
	@Inject
	ModelFactory factory;
	
	
	Person currentPerson;
	
	@PostConstruct
	void init() {
		personList.add(factory.createPerson("Tom Schindl"));
		personList.add(factory.createPerson("Lars Vogel"));
	}
	
	@Override
	public void createNewObject() {
		personList.add(factory.createPerson("John Doe"));
	}

	@Override
	public void deleteSelectedObject() {
		if( currentPerson != null ) {
			personList.remove(currentPerson);
		}
	}

	@Override
	public ObservableList<Person> getItems() {
		return personList;
	}

	@Inject
	public void setCurrentPerson(@Optional Person currentPerson) {
		this.currentPerson = currentPerson;
	}
}
