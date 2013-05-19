package my.mvc.app.controller.e4;

import my.mvc.app.controller.DIEngine;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

@SuppressWarnings("restriction")
public class DIEngineFunction extends ContextFunction {

	@Override
	public Object compute(IEclipseContext context) {
		return new DIEngineImpl(context) {
			@Override
			public void dispose() {
				
			}
		};
	}
	
	static class DIEngineImpl implements DIEngine {
		private IEclipseContext context;
		
		public DIEngineImpl(IEclipseContext context) {
			this.context = context;
		}
		
		@Override
		public <O> O create(Class<O> clazz) {
			return ContextInjectionFactory.make(clazz, context);
		}

		@Override
		public DIEngine createSubengine(String name) {
			return new DIEngineImpl(context.createChild(name));
		}

		@Override
		public void map(String key, Object value) {
			context.set(key, value);
		}

		@Override
		public <O> void map(Class<O> clazz, O o) {
			context.set(clazz, o);
		}

		@Override
		public void dispose() {
			context.dispose();
		}
		
	}
}
