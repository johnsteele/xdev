package com.steelejr.xdev.app.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class Navigator {

	@PostConstruct
	public void post (BorderPane pane) {
		Button b = new Button("Start");
		pane.setCenter(b);
	}
}