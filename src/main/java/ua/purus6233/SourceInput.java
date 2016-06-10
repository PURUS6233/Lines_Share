package ua.purus6233;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.purus6233.ImputValidators.InputParameterValidator;

import com.google.common.base.Preconditions;

public class SourceInput {

	public int numberWithinRangesChoosing(int first, int last, Scanner chooseSc) {
		int taskNumber = 0;
		do {
			System.out.println("Please enter the number (from " + first
					+ " to " + last + ") :");
			while (!chooseSc.hasNextInt()) {
				System.out
						.println("Incorrect input. Please enter the integer number!");
				chooseSc.next();
			}
			try {
				taskNumber = Integer.parseInt(chooseSc.nextLine());
			} catch (NumberFormatException e) {
			}
		} while (taskNumber<first || taskNumber>last);
		return taskNumber;
	}

	InputParameterValidator validator = new InputParameterValidator();

	private static final String SENTENCE_DELIMITERS = "[\\.!?]";

	public List<String> readSentencesFromInput(Scanner sourceSc) {
		List<String> sentenceInputContent = new ArrayList<String>();
		System.out
				.println("Enter multiple lines divided by '. ? !' or Enter. \n"
						+ "Press Enter and 'q' to quit using manual input.");
		outer: while (sourceSc.hasNextLine()) {
			String line = sourceSc.nextLine().trim();
			line = line.replaceAll("\\s+", " ");
			Pattern p = Pattern.compile(SENTENCE_DELIMITERS);
			Matcher m = p.matcher(line);
			if (m.find()) {
				String[] splitString = line.split(SENTENCE_DELIMITERS);
				for (int i = 0; i < splitString.length; i++) {
					if (splitString[i].replaceAll("\\s+", "").equals("q")) {
						break outer;
					} else {
						sentenceInputContent.add(splitString[i].replaceAll("\\s+", " ").trim());
					}
				}
			} else {
				if (line.replaceAll("\\s+", "").equals("q")) {
					break outer;
				}
				sentenceInputContent.add(line);
			}
		}
		Preconditions.checkArgument(
				!blankInputTermination(sentenceInputContent),
				"No data found. Program exit.");
		return sentenceInputContent;
	}

	public List<String> readDataFromInput(Scanner sourceSc) {
		List<String> inputByWordsContent = new ArrayList<String>();
		System.out
				.println("Enter words divided by white spase ' ' or Enter. \n"
						+ "Press 'q' to quit.");
		while (sourceSc.hasNext()) {
			String word = sourceSc.next();
			word = word.replaceAll("\\s+", "");
			if (word.equals("q")) {
				break;
			} else {
				inputByWordsContent.add(word);
			}
		}
		Preconditions.checkArgument(
				!blankInputTermination(inputByWordsContent),
				"Blank input. Program exit.");
		return inputByWordsContent;
	}

	public char orderLabelChoosing(Scanner chooseSc) {
		Scanner order = chooseSc;
		String setOrder;
		char taskOrder;
		String pattern = "^(<|>)$";
		boolean valid = false;
		do {
			setOrder = order.nextLine();
			validator.setPatternExpresion(pattern);
			valid = validator.checkWithRegExp(setOrder);
		} while (!valid);
		taskOrder = setOrder.charAt(0);
		return taskOrder;
	}

	public boolean blankInputTermination(List<String> list) {
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	public int[][] fillTwoDArrayWithSymbols(int rows, int lines, int firstInt) {
		int[][] twoDAray = new int[rows][lines];
		for (int i = 0; i < twoDAray.length; i++) {
			for (int j = 0; j < twoDAray[i].length; j++) {
				twoDAray[i][j] = firstInt++;
			}
		}
		return twoDAray;
	}
}
