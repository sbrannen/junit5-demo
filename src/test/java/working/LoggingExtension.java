
package working;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class LoggingExtension
		implements BeforeAllCallback, AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {

	private static final Logger logger = LoggerFactory.getLogger(LoggingExtension.class);

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
		logger.info(() -> "[" + Thread.currentThread().getName() + "] " + text);
	}

}
