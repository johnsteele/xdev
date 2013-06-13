package com.steelejr.xdev.fx.client.ui.view;

import javax.annotation.PostConstruct;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Navigation view for locations.
 * 
 * @author John Steele
 */
public class LocationNavigationView {

	@PostConstruct
	public void createView (BorderPane pane) {
		
		VBox box = new VBox();
		
		Button gitButton = new Button();
		Tooltip tip = new Tooltip("GitHub");
		gitButton.setText("GitHub");
		gitButton.setTooltip(tip);
		
		box.getChildren().add(gitButton);
		
		gitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		
		Button bitButton = new Button();
		tip = new Tooltip ("BitBucket");
		bitButton.setTooltip(tip);
		bitButton.setText("BitBucket");
		
		box.getChildren().add(bitButton);
		
		pane.setCenter(box);
	}
}
