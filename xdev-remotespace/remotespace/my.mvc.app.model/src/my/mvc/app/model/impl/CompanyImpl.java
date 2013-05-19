package my.mvc.app.model.impl;

import my.mvc.app.model.Company;

public class CompanyImpl implements Company {
	private String name;
	
	public CompanyImpl(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
