/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package extensions;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;
import static org.junit.platform.commons.support.AnnotationSupport.isAnnotated;
import static org.junit.platform.commons.support.ModifierSupport.isNotStatic;

import java.util.Optional;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestWatcher;

/**
 * Extension that tracks whether a test failed in a test class, stores that
 * information in the root {@link ExtensionContext}, and skips
 * {@link Nested @Nested} test classes if they are annotated with
 * {@link SkipOnFailuresInEnclosingClass @SkipOnFailuresInEnclosingClass} and
 * the enclosing test class had test failures.
 *
 * @author Sam Brannen
 * @see SkipOnFailuresInEnclosingClass
 */
public class SkipOnFailuresInEnclosingClassExtension implements TestWatcher, ExecutionCondition {

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		// Track failures by test class name instead of test Class in order to
		// avoid holding onto Class references in the root ExecutionContext.Store
		// for the duration of the test suite.
		getStore(context).put(context.getRequiredTestClass().getName(), true);
	}

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		Class<?> testClass = context.getRequiredTestClass();

		if (isInnerClass(testClass) && isAnnotated(testClass, SkipOnFailuresInEnclosingClass.class)) {
			Store store = getStore(context);
			String enclosingClassName = testClass.getDeclaringClass().getName();
			boolean failureRecordedInEnclosingClass = getOrElse(store, enclosingClassName, boolean.class, false);
			if (failureRecordedInEnclosingClass) {
				return disabled("Failures detected in enclosing test class: " + enclosingClassName);
			}
		}

		return enabled("No failing tests in enclosing class");
	}

	private Store getStore(ExtensionContext context) {
		return context.getRoot().getStore(Namespace.create(getClass()));
	}

	private <V> V getOrElse(Store store, Object key, Class<V> requiredType, V defaultValue) {
		V value = store.get(key, requiredType);
		return (value != null ? value : defaultValue);
	}

	private static boolean isInnerClass(Class<?> clazz) {
		return isNotStatic(clazz) && clazz.isMemberClass();
	}

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
		// ignored event
	}

	@Override
	public void testSuccessful(ExtensionContext context) {
		// ignored event
	}

	@Override
	public void testAborted(ExtensionContext context, Throwable cause) {
		// ignored event
	}

}
