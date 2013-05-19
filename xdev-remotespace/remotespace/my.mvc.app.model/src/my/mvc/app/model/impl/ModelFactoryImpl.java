package my.mvc.app.model.impl;

import my.mvc.app.model.Company;
import my.mvc.app.model.ModelFactory;
import my.mvc.app.model.Person;

public class ModelFactoryImpl implements ModelFactory {

	@Override
	public Person createPerson(String name) {
		return new PersonImpl(name);
	}

	@Override
	public Company createCompany(String name) {
		return new CompanyImpl(name);
	}

}
