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

import my.mvc.app.controller.CompanyViewController;
import my.mvc.app.controller.DIEngine;
import my.mvc.app.model.Company;

import org.eclipse.e4.ui.di.Focus;

@SuppressWarnings("restriction")
public class CompanyView {
	private final CompanyViewController controller;
	private ListView<Company> companyView;
	
	@Inject
	DIEngine diEngine;
	
	@Inject
	public CompanyView(CompanyViewController controller) {
		this.controller = controller;
	}
	
	@PostConstruct
	void init(BorderPane pane) {
		companyView = new ListView<>();
		companyView.setCellFactory(new Callback<ListView<Company>, ListCell<Company>>() {
			
			@Override
			public ListCell<Company> call(ListView<Company> arg0) {
				return new ListCell<Company>() {
					@Override
					protected void updateItem(Company arg0, boolean arg1) {
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
		companyView.setItems(controller.getItems());
		companyView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Company>() {
			@Override
			public void changed(ObservableValue<? extends Company> arg0,
					Company arg1, Company arg2) {
				diEngine.map(Company.class, arg2);
			}
		});
		pane.setCenter(companyView);
	}
	
	
	@Focus
	void setFocus() {
		companyView.requestFocus();
	}
}
