package ua.purus6233;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OrderTest {
	@Test
	public void test_getOrder() {
		assertEquals(Order.getOrder('>'), Order.ASCENDING);
		assertEquals(Order.getOrder('<'), Order.DESCENDING);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_getOrder_$Incorrect_data() {
		assertEquals(Order.getOrder(' '), Order.ASCENDING);
		assertEquals(Order.getOrder('1'), Order.DESCENDING);
	}
}
