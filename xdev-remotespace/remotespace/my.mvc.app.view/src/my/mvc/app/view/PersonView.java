package my.mvc.app.view;

import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import my.mvc.app.controller.DIEngine;
import my.mvc.app.controller.PersonViewController;
import my.mvc.app.model.Person;

import org.eclipse.e4.ui.di.Focus;

@SuppressWarnings("restriction")
public class PersonView {
	private final PersonViewController controller;
	private ListView<Person> personView;
	
	@Inject
	DIEngine diEngine;
	
	@Inject
	public PersonView(PersonViewController controller) {
		this.controller = controller;
	}
	
	@PostConstruct
	void init(BorderPane pane) {
		personView = new ListView<>();
		personView.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
			
			@Override
			public ListCell<Person> call(ListView<Person> arg0) {
				return new ListCell<Person>() {
					@Override
					protected void updateItem(Person arg0, boolean arg1) {
						if( arg0 != null && ! arg1 ) {
							try {
								textProperty().bind(JavaBeanStringPropertyBuilder.create().bean(arg0).name("name").build());
							} catch (NoSuchMethodException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							textProperty().unbind();
							setText(null);
						}
						super.updateItem(arg0, arg1);
					}
				};
			}
		});
		personView.setItems(controller.getItems());
		personView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

			@Override
			public void changed(ObservableValue<? extends Person> arg0,
					Person arg1, Person arg2) {
				diEngine.map(Person.class, arg2);
			}
		});
		
		pane.setCenter(personView);
	}
	
	
	@Focus
	void setFocus() {
		personView.requestFocus();
	}
}
