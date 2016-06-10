package ua.purus6233;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MonthTest {
	
	@Test
	public void test_getOrder() {
		assertEquals(Month.valueOf(1), Month.JANUARY);
		assertEquals(Month.valueOf(7), Month.JULY);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_getOrder_$Incorrect_data() {
		assertEquals(Month.valueOf(55), Month.JANUARY);
		assertEquals(Month.valueOf(0), Month.JULY);
	}
}

