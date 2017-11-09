
package working;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(EnabledOn.Extension.class)
public @interface EnabledOn {

	DayOfWeek value();

	class Extension implements ExecutionCondition {

		@Override
		public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
			DayOfWeek today = LocalDate.now().getDayOfWeek();

			return AnnotationSupport.findAnnotation(context.getElement().get(), EnabledOn.class)//
					.map(EnabledOn::value)//
					.filter(day -> day != today)//
					.map(day -> ConditionEvaluationResult.disabled("Only enabled on " + day))//
					.orElseGet(() -> ConditionEvaluationResult.enabled("Enabled on " + today));
		}
	}

}
