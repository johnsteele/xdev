package my.mvc.app.model.impl;

import my.mvc.app.model.Person;

public class PersonImpl implements Person {
	private String name;
	
	public PersonImpl(String name) {
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
