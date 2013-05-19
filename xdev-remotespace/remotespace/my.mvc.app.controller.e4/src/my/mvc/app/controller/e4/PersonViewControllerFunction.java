package my.mvc.app.controller.e4;

import my.mvc.app.controller.ListViewController;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

@SuppressWarnings("restriction")
public class PersonViewControllerFunction extends ContextFunction {

	@Override
	public Object compute(IEclipseContext context) {
		PersonViewControllerImpl c = ContextInjectionFactory.make(PersonViewControllerImpl.class, context);
		context.set(ListViewController.class, c);
		return c;
	}

}
