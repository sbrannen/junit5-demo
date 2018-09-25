
package working;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggingExtension
		implements BeforeAllCallback, AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		print("Before all : " + context.getDisplayName());
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		print("After all  : " + context.getDisplayName());
	}

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		print("Before test execution : " + context.getDisplayName());
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		print("After test execution  : " + context.getDisplayName());
	}

	private static void print(String text) {
		System.out.println("[" + Thread.currentThread().getName() + "] " + text);
	}

}
