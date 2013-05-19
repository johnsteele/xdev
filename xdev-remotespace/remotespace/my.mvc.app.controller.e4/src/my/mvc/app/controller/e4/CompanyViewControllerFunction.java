package my.mvc.app.controller.e4;

import my.mvc.app.controller.ListViewController;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

@SuppressWarnings("restriction")
public class CompanyViewControllerFunction extends ContextFunction {

	@Override
	public Object compute(IEclipseContext context) {
		System.err.println("CALLED");
		CompanyViewControllerImpl c = ContextInjectionFactory.make(CompanyViewControllerImpl.class, context);
		context.set(ListViewController.class, c);
		System.err.println("====>" + c);
		return c;
	}

}
