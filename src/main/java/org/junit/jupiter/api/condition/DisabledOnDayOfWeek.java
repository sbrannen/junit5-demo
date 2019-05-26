/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.api.condition;

import static org.apiguardian.api.API.Status.STABLE;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;
import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @see EnabledOnDayOfWeek
 * @see org.junit.jupiter.api.Disabled
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(DisabledOnDayOfWeek.Condition.class)
@API(status = STABLE, since = "5.1")
public @interface DisabledOnDayOfWeek {

	DayOfWeek[] value();

	class Condition implements ExecutionCondition {

		private static final ConditionEvaluationResult ENABLED_BY_DEFAULT = enabled(
			"@DisabledOnDayOfWeek is not present");

		@Override
		public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
			Optional<DisabledOnDayOfWeek> optional = findAnnotation(context.getElement(), DisabledOnDayOfWeek.class);

			if (!optional.isPresent()) {
				return ENABLED_BY_DEFAULT;
			}

			DayOfWeek today = LocalDate.now().getDayOfWeek();
			return (Arrays.stream(optional.get().value()).anyMatch(today::equals)) ?
				disabled("Disabled on " + today) :
				enabled("Enabled on " + today);
		}

	}

}
