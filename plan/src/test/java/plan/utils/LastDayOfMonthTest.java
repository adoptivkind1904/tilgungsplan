package plan.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LastDayOfMonthTest {
	@Test
	public void lastDayTest() {
		LastDayOfMonth ldom = new LastDayOfMonth(11, 2020);
		ldom.setMonth(1);
		assertEquals(31, ldom.lastDay());
		ldom.setMonth(2);
		assertEquals(28, ldom.lastDay());
		ldom.setMonth(3);
		assertEquals(31, ldom.lastDay());
		ldom.setMonth(4);
		assertEquals(30, ldom.lastDay());
		ldom.setMonth(5);
		assertEquals(31, ldom.lastDay());
		ldom.setMonth(6);
		assertEquals(30, ldom.lastDay());
		ldom.setMonth(7);
		assertEquals(31, ldom.lastDay());
		ldom.setMonth(8);
		assertEquals(31, ldom.lastDay());
		ldom.setMonth(9);
		assertEquals(30, ldom.lastDay());
		ldom.setMonth(10);
		assertEquals(31, ldom.lastDay());
		ldom.setMonth(11);
		assertEquals(30, ldom.lastDay());
		ldom.setMonth(12);
		assertEquals(31, ldom.lastDay());
	}
	
	@Test
	public void ConstructorTest() {
		LastDayOfMonth ldom = new LastDayOfMonth(1, 2020);
		assertEquals(31, ldom.getDay());
		ldom = new LastDayOfMonth(2, 2020);
		assertEquals(28, ldom.getDay());
		ldom = new LastDayOfMonth(3, 2020);
		assertEquals(31, ldom.getDay());
		ldom = new LastDayOfMonth(4, 2020);
		assertEquals(30, ldom.getDay());
		ldom = new LastDayOfMonth(5, 2020);
		assertEquals(31, ldom.getDay());
		ldom = new LastDayOfMonth(6, 2020);
		assertEquals(30, ldom.getDay());
		ldom = new LastDayOfMonth(7, 2020);
		assertEquals(31, ldom.getDay());
		ldom = new LastDayOfMonth(8, 2020);
		assertEquals(31, ldom.getDay());
		ldom = new LastDayOfMonth(9, 2020);
		assertEquals(30, ldom.getDay());
		ldom = new LastDayOfMonth(10, 2020);
		assertEquals(31, ldom.getDay());
		ldom = new LastDayOfMonth(11, 2020);
		assertEquals(30, ldom.getDay());
		ldom = new LastDayOfMonth(12, 2020);
		assertEquals(31, ldom.getDay());

	}
	
	@Test
	public void incMonthTest() {
		LastDayOfMonth ldom = new LastDayOfMonth(1, 2020);
		ldom.incMonth();
		assertEquals(2, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(3, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(4, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(5, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(6, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(7, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(8, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(9, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(10, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(11, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(12, ldom.getMonth());
		assertEquals(2020, ldom.getYear());
		ldom.incMonth();
		assertEquals(1, ldom.getMonth());
		assertEquals(2021, ldom.getYear());
	}
}
