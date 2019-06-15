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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Nested;

/**
 * Class-level annotation which signals that the annotated {@link Nested @Nested}
 * test class should be skipped if the enclosing test class had test failures.
 *
 * <p>The enclosing test class must register the
 * {@link SkipOnFailuresInEnclosingClassExtension} in order for this annotation
 * to have any effect.
 *
 * @author Sam Brannen
 * @see SkipOnFailuresInEnclosingClassExtension
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SkipOnFailuresInEnclosingClass {
}
