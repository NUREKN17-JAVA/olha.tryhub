package ua.nure.kn.trigub.domain;

import junit.framework.TestCase;
import ua.nure.kn.trigub.domain.User;

import java.util.Calendar;

public class UserTest extends TestCase {

	private static final String ETALONE_FULL_NAME = "Trigub, Olia";
	private static final String ETALONE_SURNAME = "Trigub";
	private static final String ETALONE_NAME = "Olia";
	private static final int ETALONE_MONTH = Calendar.FEBRUARY;
	private static final int ETALONE_DATE = 18;
	private static final int BIRTH_YEAR = 2000;
	private static final int CURRNET_YEAR = 2019;
	private static final int ETALONE_AGE = 19;

	// Test case №1 birth date the day before

	private static final int BIRTH_MONTH_BEFORE_DAY = Calendar.FEBRUARY;
	private static final int BIRTH_DAY_BEFORE_DAY = ETALONE_DATE - 1;
	private static final int ETALONE_AGE_BEFORE_DAY = CURRNET_YEAR - BIRTH_YEAR;

	// Test case №2 birth date the month before

	private static final int BIRTH_MONTH_BEFORE_MONTH = ETALONE_MONTH - 1;
	private static final int BIRTH_DAY_BEFORE_MONTH = ETALONE_AGE;
	private static final int ETALONE_AGE_BEFORE_MONTH = CURRNET_YEAR - BIRTH_YEAR;

	// Test case №3 date equal current date

	private static final int BIRTH_MONTH_EQ_DATE = Calendar.FEBRUARY;
	private static final int BIRTH_DAY_EQ_DATE = ETALONE_DATE + 1;
	private static final int ETALONE_AGE_EQ_DATE = ETALONE_AGE + 1;

	// Test case №4 birth date the day after
	private static final int BIRTH_MONTH_AFTER_DAY = Calendar.FEBRUARY;
	private static final int BIRTH_DAY_AFTER_DAY = ETALONE_DATE + 1;
	private static final int ETALONE_AGE_AFTER_DAY = ETALONE_AGE + 1;

	// Test case №5 birth date the month after

	private static final int BIRTH_MONTH_AFTER_MONTH = Calendar.MARCH;
	private static final int BIRTH_DAY_AFTER_MONTH = ETALONE_AGE + 1;
	private static final int ETALONE_AGE_AFTER_MONTH = ETALONE_AGE + 1;

	private User user;

	public void setUp() throws Exception {
		super.setUp();
        user = new User();
	}

	public void tearDown() throws Exception {
	}

	//test Full Name
	public void testGetFullName() {
		user.setFirstName(ETALONE_NAME);
		user.setLastName(ETALONE_SURNAME);
		assertEquals(ETALONE_FULL_NAME, user.getFullName());
	}

	// Code for first case
	public void testGetAge1() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(BIRTH_YEAR, BIRTH_MONTH_BEFORE_DAY, BIRTH_DAY_BEFORE_DAY);

		user.setDateOfBirthd(calendar.getTime());
		assertEquals(ETALONE_AGE_BEFORE_DAY, user.getAge());
	}

	// @test
	// // Code for second case
	public void testGetAge2() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(BIRTH_YEAR, BIRTH_MONTH_BEFORE_MONTH, BIRTH_DAY_BEFORE_MONTH);

		user.setDateOfBirthd(calendar.getTime());
		assertEquals(ETALONE_AGE_BEFORE_MONTH, user.getAge());
	}

	// @test
	// // Code for third case
	public void testGetAge3() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(BIRTH_YEAR, BIRTH_MONTH_EQ_DATE, BIRTH_DAY_EQ_DATE);

		user.setDateOfBirthd(calendar.getTime());
		assertEquals(ETALONE_AGE_EQ_DATE, user.getAge());
	}

	// @test
	// // Code for fourth case
	public void testGetAge4() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(BIRTH_YEAR, BIRTH_MONTH_AFTER_DAY, BIRTH_DAY_AFTER_DAY);

		user.setDateOfBirthd(calendar.getTime());
		assertEquals(ETALONE_AGE_AFTER_DAY, user.getAge());
	}

	// @test
	// // Code for fifth case
	public void testGetAge5() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(BIRTH_YEAR, BIRTH_MONTH_AFTER_MONTH, BIRTH_DAY_AFTER_MONTH);

		user.setDateOfBirthd(calendar.getTime());
		assertEquals(ETALONE_AGE_AFTER_MONTH, user.getAge());
	}

}