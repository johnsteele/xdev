package my.mvc.app.model;

public interface ModelFactory {
	public Person createPerson(String name);
	public Company createCompany(String name);
}
