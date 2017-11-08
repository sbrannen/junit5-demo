
package working;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggingExtension
		implements BeforeAllCallback, AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		System.out.println("Before test execution: " + context.getRequiredTestMethod().getName());
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		System.out.println("After test execution: " + context.getRequiredTestMethod().getName());
	}

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		System.out.println("Before all: " + context.getRequiredTestClass().getName());
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		System.out.println("After all: " + context.getRequiredTestClass().getName());
	}

}
