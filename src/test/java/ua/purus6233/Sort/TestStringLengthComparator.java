package ua.purus6233.Sort;

import org.junit.Assert;
import org.junit.Test;

public class TestStringLengthComparator extends Assert{//TODO delete
	
	@Test
	public void test_type() throws Exception {
		assertNotNull(StringLengthComparator.class);
	}
	
	@Test
	public void test_instantiation() throws Exception {
		StringLengthComparator target = new StringLengthComparator();
		assertNotNull(target);
	}
	
	@Test
	public void test_compare() throws Exception {
		StringLengthComparator a = new StringLengthComparator();
		int expected_1 = 1;
		final int actual = a.compare("123456", "123");
		assertEquals(expected_1, actual);
		
		int expected_2 = 0;
		assertFalse(expected_2==actual);
		
		int expected_3 = -1;
		assertFalse(expected_3==actual);
	}
}
