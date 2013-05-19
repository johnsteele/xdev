package my.mvc.app.controller;

import javafx.collections.ObservableList;

public interface ListViewController<O> {
	public void createNewObject();
	public void deleteSelectedObject();
	public ObservableList<O> getItems();
}
