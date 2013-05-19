package my.mvc.app.controller.e4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import my.mvc.app.controller.CompanyViewController;
import my.mvc.app.model.Company;
import my.mvc.app.model.ModelFactory;

import org.eclipse.e4.core.di.annotations.Optional;

@SuppressWarnings("restriction")
public class CompanyViewControllerImpl implements CompanyViewController {
	private ObservableList<Company> companyList = FXCollections.observableArrayList();
	
	@Inject
	ModelFactory factory;
	
	
	Company currentCompany;
	
	@PostConstruct
	void init() {
		companyList.add(factory.createCompany("BestSolution.at"));
		companyList.add(factory.createCompany("Vogella.com"));
	}
	
	@Override
	public void createNewObject() {
		companyList.add(factory.createCompany("New Company"));
	}

	@Override
	public void deleteSelectedObject() {
		if( currentCompany != null ) {
			companyList.remove(currentCompany);
		}
	}

	@Override
	public ObservableList<Company> getItems() {
		return companyList;
	}

	@Inject
	public void setCurrentCompany(@Optional Company currentCompany) {
		this.currentCompany = currentCompany;
	}
}
