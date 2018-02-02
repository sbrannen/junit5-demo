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
 * Unit tests for {@link EnabledOnDayOfWeek}.
 */
class EnabledOnDayOfWeekTests {

	private final DayOfWeek today = LocalDate.now().getDayOfWeek();

	@Test
	@EnabledOnDayOfWeek(MONDAY)
	void monday() {
		assertThat(today).isEqualTo(MONDAY);
	}

	@Test
	@EnabledOnDayOfWeek(TUESDAY)
	void tuesday() {
		assertThat(today).isEqualTo(TUESDAY);
	}

	@Test
	@EnabledOnDayOfWeek(WEDNESDAY)
	void wednesday() {
		assertThat(today).isEqualTo(WEDNESDAY);
	}

	@Test
	@EnabledOnDayOfWeek(THURSDAY)
	void thursday() {
		assertThat(today).isEqualTo(THURSDAY);
	}

	@Test
	@EnabledOnDayOfWeek(FRIDAY)
	void friday() {
		assertThat(today).isEqualTo(FRIDAY);
	}

	@Test
	@EnabledOnDayOfWeek(SATURDAY)
	void saturday() {
		assertThat(today).isEqualTo(SATURDAY);
	}

	@Test
	@EnabledOnDayOfWeek(SUNDAY)
	void sunday() {
		assertThat(today).isEqualTo(SUNDAY);
	}

	@Test
	@EnabledOnWeekdays
	void weekdays() {
		assertThat(EnumSet.range(MONDAY, FRIDAY)).contains(today);
	}

	@Test
	@EnabledOnWeekends
	void weekends() {
		assertThat(EnumSet.range(SATURDAY, SUNDAY)).contains(today);
	}

	// -------------------------------------------------------------------------

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@EnabledOnDayOfWeek({ MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY })
	@interface EnabledOnWeekdays {
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@EnabledOnDayOfWeek({ SATURDAY, SUNDAY })
	@interface EnabledOnWeekends {
	}

}
