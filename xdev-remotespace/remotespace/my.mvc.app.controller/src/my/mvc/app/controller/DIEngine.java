package my.mvc.app.controller;

public interface DIEngine {
	public <O> O create(Class<O> clazz);
	public DIEngine createSubengine(String name);
	public void map(String key, Object value);
	public <O> void map(Class<O> clazz, O o);
	public void dispose();
}
