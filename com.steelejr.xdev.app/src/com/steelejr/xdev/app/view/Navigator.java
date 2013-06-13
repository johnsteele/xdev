package com.steelejr.xdev.app.view;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javax.annotation.PostConstruct;

public class Navigator {

	@PostConstruct
	public void post (BorderPane pane) {
		VBox layout = new VBox();
		Button gitHubBtn = new Button();
		Tooltip tip = new Tooltip("GitHub");
		gitHubBtn.setTooltip(tip);
		layout.getChildren().add(gitHubBtn);
	}
}
