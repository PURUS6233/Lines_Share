package ua.purus6233;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TaskBodyTest {

	private static final List<String> INPUT_SENTENCE = Arrays.asList(
			"When the going gets tough, the tough get going.",
			"No man is an island.", "The squeaky wheel gets the grease.");
	private static final List<String> INPUT_WORDS = Arrays.asList("Algebra",
			"palindrome", "work", "фонарик", "1ф2ab", "algeb1ra", "actual",
			"mutality", "12345", "hary", "12321", "deed", "refer", "15751");

	@Test
	public void test_type() throws Exception {
		assertNotNull(TaskBody.class);
	}

	TaskBody body = new TaskBody();

	@Test
	public void test_initialiation() throws Exception {
		assertNotNull(body);
	}

	@Test
	public void test_createSubList() throws Exception {
		List<String> expected = Arrays.asList(
				"When the going gets tough, the tough get going.",
				"No man is an island.");
		int fromIndex = 0;
		int tillIndex = 2;
		List<String> actual = body.createSubList(INPUT_SENTENCE, fromIndex,
				tillIndex);

		assertTrue(actual.size() == expected.size());
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void test_findShortLongSentence() throws Exception {
		List<String> expected = Arrays
				.asList("Shortest sentence: No man is an island. (20)",
						"Longest sentence: When the going gets tough, the tough get going. (47)");
		List<String> actual = body.findShortLongSentence(INPUT_SENTENCE);

		assertTrue(actual.size() == expected.size());
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void test_orderSelection_$ASCENDING() throws Exception {
		List<String> expected_ASC = Arrays.asList("No man is an island.",
				"The squeaky wheel gets the grease.",
				"When the going gets tough, the tough get going.");
		Order order_ASC = Order.getOrder('>');
		List<String> actual_ASC = body
				.orderSelection(INPUT_SENTENCE, order_ASC);

		assertTrue(actual_ASC.size() == expected_ASC.size());
		assertEquals(expected_ASC.toString(), actual_ASC.toString());
	}

	@Test
	public void test_orderSelection_$DESCENDING() throws Exception {
		List<String> expected_DESC = Arrays.asList(
				"When the going gets tough, the tough get going.",
				"The squeaky wheel gets the grease.", "No man is an island.");
		Order order_DESC = Order.getOrder('<');
		List<String> actual_DESC = body.orderSelection(INPUT_SENTENCE,
				order_DESC);

		assertTrue(actual_DESC.size() == expected_DESC.size());
		assertEquals(expected_DESC.toString(), actual_DESC.toString());
	}

	@Test
	public void test_findRequiredPart_$ASCENDING() throws Exception {
		List<String> expected_ASC = Arrays.asList("No man is an island.",
				"The squeaky wheel gets the grease.");
		Order order_ASC = Order.getOrder('>');
		List<String> actual_ASC = body.findRequiredPart(INPUT_SENTENCE,
				order_ASC);

		assertTrue(actual_ASC.size() == expected_ASC.size());
		assertEquals(expected_ASC.toString(), actual_ASC.toString());
	}

	@Test
	public void test_findRequiredPart_$DESCENDING() throws Exception {
		List<String> expected_DESC = Arrays
				.asList("When the going gets tough, the tough get going.");
		Order order_DESC = Order.getOrder('<');
		List<String> actual_DESC = body.findRequiredPart(INPUT_SENTENCE,
				order_DESC);

		assertTrue(actual_DESC.size() == expected_DESC.size());
		assertEquals(expected_DESC.toString(), actual_DESC.toString());
	}

	@Test
	public void test_findFirstWordWithMinimumDifferentSymbols()
			throws Exception {
		String expected = "deed";
		String actual = body
				.findFirstWordWithMinimumDifferentSymbols(INPUT_WORDS);

		assertEquals(expected, actual);
	}

	@Test
	public void test_findLatinCharWords() throws Exception {
		List<String> expected = Arrays.asList("Algebra", "palindrome", "work",
				"actual", "mutality", "hary", "deed", "refer");
		List<String> actual = body.findLatinCharWords(INPUT_WORDS);
		
		assertTrue(actual.size() == expected.size());
		assertEquals(expected, actual);
	}
	
	private static final List<String> LATIN_WORDS_LIST = Arrays.asList("Algebra", "palindrome", "work",
			"actual", "mutality", "hary", "deed", "refer");
	
	@Test
	public void test_counterEqualConsVovelWords() throws Exception {
		int expected = 4;
		int actual = body.counterEqualConsVovelWords(LATIN_WORDS_LIST);
		
		assertEquals(expected, actual);
	}
}
