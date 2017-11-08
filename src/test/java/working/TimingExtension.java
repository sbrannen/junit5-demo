
package working;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		long start = System.currentTimeMillis();
		getStore(context).put("START", start);
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		long start = getStore(context).get("START", long.class);
		long duration = System.currentTimeMillis() - start;
		// System.out.println("Test method " + context.getRequiredTestMethod().getName() + " took " + duration + " ms");
		context.publishReportEntry("exucution time", "" + duration);
	}

	private Store getStore(ExtensionContext context) {
		return context.getStore(Namespace.create(context.getRequiredTestMethod()));
	}

}
