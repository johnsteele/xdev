 
package com.steelejr.xdev.fx.app.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;

public class Editor {
	@Inject
	public Editor() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(BorderPane pane) {
		Button b = new Button ("Editor");
		pane.setCenter(b);
	}
	
	@PreDestroy
	public void preDestroy() {
	}
	
	
	@Focus
	public void onFocus() {
	}
	
	@Persist
	public void save() {
	}
	
}