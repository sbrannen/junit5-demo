/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.api.condition;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link DisabledOnDayOfWeek}.
 */
class DisabledOnDayOfWeekTests {

	private final DayOfWeek today = LocalDate.now().getDayOfWeek();

	@Test
	@DisabledOnDayOfWeek(MONDAY)
	void monday() {
		assertThat(today).isNotEqualTo(MONDAY);
	}

	@Test
	@DisabledOnDayOfWeek(TUESDAY)
	void tuesday() {
		assertThat(today).isNotEqualTo(TUESDAY);
	}

	@Test
	@DisabledOnDayOfWeek(WEDNESDAY)
	void wednesday() {
		assertThat(today).isNotEqualTo(WEDNESDAY);
	}

	@Test
	@DisabledOnDayOfWeek(THURSDAY)
	void thursday() {
		assertThat(today).isNotEqualTo(THURSDAY);
	}

	@Test
	@DisabledOnDayOfWeek(FRIDAY)
	void friday() {
		assertThat(today).isNotEqualTo(FRIDAY);
	}

	@Test
	@DisabledOnDayOfWeek(SATURDAY)
	void saturday() {
		assertThat(today).isNotEqualTo(SATURDAY);
	}

	@Test
	@DisabledOnDayOfWeek(SUNDAY)
	void sunday() {
		assertThat(today).isNotEqualTo(SUNDAY);
	}

	@Test
	@DisabledOnWeekdays
	void weekdays() {
		assertThat(EnumSet.range(MONDAY, FRIDAY)).doesNotContain(today);
	}

	@Test
	@DisabledOnWeekends
	void weekends() {
		assertThat(EnumSet.range(SATURDAY, SUNDAY)).doesNotContain(today);
	}

	// -------------------------------------------------------------------------

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@DisabledOnDayOfWeek({ MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY })
	@interface DisabledOnWeekdays {
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@DisabledOnDayOfWeek({ SATURDAY, SUNDAY })
	@interface DisabledOnWeekends {
	}

}
