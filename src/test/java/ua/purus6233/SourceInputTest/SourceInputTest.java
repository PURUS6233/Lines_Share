package ua.purus6233.SourceInputTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

import ua.purus6233.SourceInput;

public class SourceInputTest {

	private static final List<String> BlANK_INPUT = Arrays.asList();
	private static final List<String> INPUT = Arrays.asList("not", "empty",
			"list");
	private Scanner scan;

		@Test
	public void test_type() throws Exception {
		assertNotNull(SourceInput.class);
	}

	@Test
	public void test_initialiation() throws Exception {
		SourceInput source = new SourceInput();
		assertNotNull(source);
	}

	SourceInput source = new SourceInput();

	@Test
	public void test_blankInputTermination_blank() throws Exception {
		boolean expected = source.blankInputTermination(BlANK_INPUT);
		assertTrue(expected);
	}

	@Test
	public void test_blankInputTermination() throws Exception {
		boolean expected = source.blankInputTermination(INPUT);
		assertFalse(expected);
	}

	private static final String DATA_1 = "1";
	private static final String DATA_2 = "0";

	@Test
	public void test_numberWithinRangesChoosing_$DATA_1() throws Exception {
		scan = new Scanner(DATA_1);
		int expected = 1;
		int actual = source.numberWithinRangesChoosing(1, 13, scan);
		assertTrue(expected == actual);
	}

	@Ignore("Method returns only true data")
	@Test
	public void test_numberWithinRangesChoosing_$DATA_2() throws Exception {
		scan = new Scanner(DATA_2);
		int expected = 0;
		int actual = source.numberWithinRangesChoosing(1, 13, scan);
		assertFalse(expected == actual);
	}
	
	private static final String CHAR_1 = " > ";
	private static final String CHAR_2 = " < ";
	
	@Test
	public void test_orderLabelChoosing_$CHAR_1() throws Exception {
		scan = new Scanner(CHAR_1);
		char expected = '>';
		char actual = source.orderLabelChoosing(scan);
		assertTrue(expected == actual);
	}

	@Test
	public void test_orderLabelChoosing_$CHAR_2() throws Exception {
		scan = new Scanner(CHAR_2);
		char expected = '<';
		char actual = source.orderLabelChoosing(scan);
		assertTrue(expected == actual);
	}
}
