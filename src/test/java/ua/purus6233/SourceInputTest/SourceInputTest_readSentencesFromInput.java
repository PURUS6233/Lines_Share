package ua.purus6233.SourceInputTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;

import ua.purus6233.SourceInput;

public class SourceInputTest_readSentencesFromInput {
	
	private Scanner scan;
	SourceInput source = new SourceInput();

	@Test(expected = IllegalArgumentException.class)
	// TODO
	public void test_readSentencesFromInput_A$Blank() throws Exception {
		String input = "";
		scan = new Scanner(input);
		Collection<String> actual = source.readSentencesFromInput(scan);
		Collection<String> expected = Arrays.asList();
		assertEquals(expected, actual);
	}

	@Test(expected = NullPointerException.class)
	// TODO
	public void test_readSentencesFromInput_B$Null() throws Exception {
		String input = null;
		scan = new Scanner(input);
		Collection<String> actual = source.readSentencesFromInput(scan);
		Collection<String> expected = Arrays.asList();
		assertEquals(expected, actual);
	}

	@Test
	public void test_readSentencesFromInput_C$File() throws Exception {
		String pathToFile = "src/test/testResource/input.txt";
		scan = new Scanner(Paths.get(pathToFile));
		Collection<String> actual = source.readSentencesFromInput(scan);
		Collection<String> expected = Arrays.asList(
				"When the going gets tough, the tough get going",
				"No man is an island", "The squeaky wheel gets the grease");
		assertEquals(expected, actual);
		assertTrue(actual.size() == expected.size());
	}
}
