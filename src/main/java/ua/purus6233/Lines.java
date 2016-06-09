package ua.purus6233;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import ua.purus6233.QuadraticEquation.QuadraticEquation;

public class Lines {

	private final Scanner sourceSc;
	private final Scanner chooseSc = new Scanner(System.in);

	public Scanner getSourceSc() {
		return sourceSc;
	}

	public Scanner getChooseSc() {
		return chooseSc;
	}

	public Lines(InputStream inStream) {
		this.sourceSc = sourceRemake(inStream);
	}

	private Scanner sourceRemake(InputStream inStream) {
		Scanner sc = new Scanner(inStream);
		return sc;
	}

	private static final int FIRST_TASK = 1;
	private static final int LAST_TASK = 13;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		TaskBody tb = new TaskBody();
		InputStream inputSource = null;// TODO
		String pathToFile = "c:\\1.txt";
		try {
			inputSource = new FileInputStream(pathToFile);
		} catch (FileNotFoundException e1) {
			inputSource = System.in;
		}
		SourceInput source = new SourceInput();
		Lines lines = new Lines(inputSource);
		List<String> sourceSentenceStrings;
		List<String> sourceWordsString;
		int task = source.numberWithinRangesChoosing(FIRST_TASK, LAST_TASK,
				lines.getChooseSc());

		switch (task) {
		case 1:
			sourceSentenceStrings = source.readSentencesFromInput(lines
					.getSourceSc());
			List<String> listShortLong = tb
					.findShortLongSentence(sourceSentenceStrings);
			for (String label : listShortLong) {
				System.out.println(label);
			}
			break;

		case 2:
			sourceSentenceStrings = source.readSentencesFromInput(lines
					.getSourceSc());
			System.out
					.println("Please enter the order (type '>' for ascending order or '<' for descending):");
			char orderSighn = source.orderLabelChoosing(lines.getChooseSc());
			Order orderEnum = Order.getOrder(orderSighn);
			List<String> listOrder = tb.orderSelection(sourceSentenceStrings,
					orderEnum);
			for (String label : listOrder) {
				System.out.println(label);
			}
			break;

		case 3:
			sourceSentenceStrings = source.readSentencesFromInput(lines
					.getSourceSc());
			System.out
					.println("Please enter the list part "
							+ "(type '>' for sentences from middle to end or '<' from middle to the first sentence):");
			char order = source.orderLabelChoosing(lines.getChooseSc());
			Order listPartEnum = Order.getOrder(order);
			List<String> listPart = tb.findRequiredPart(sourceSentenceStrings,
					listPartEnum);
			for (String label : listPart) {
				System.out.println(label);
			}
			break;

		case 4:
			sourceWordsString = source.readDataFromInput(lines.getSourceSc());
			String word = tb
					.findFirstWordWithMinimumDifferentSymbols(sourceWordsString);
			System.out.println("Word with minimum different symbols: " + word
					+ ".");
			break;
		case 5:
			sourceWordsString = source.readDataFromInput(lines.getSourceSc());
			List<String> latinWords = tb.findLatinCharWords(sourceWordsString);
			System.out.println("Number of words with only latin symbols: "
					+ (latinWords.size()));
			int equalVovConsNumber = tb.counterEqualConsVovelWords(latinWords);
			System.out
					.println("Number of words with equal amount of vovels and consonants: "
							+ equalVovConsNumber);
			break;
		case 6:
			sourceWordsString = source.readDataFromInput(lines.getSourceSc());
			String ascendingOrderWord = tb
					.findFirstWordWithCharCodeAscOrder(sourceWordsString);
			System.out
					.println("The first word with ascending character order is: "
							+ ascendingOrderWord);
			break;
		case 7:
			sourceWordsString = source.readDataFromInput(lines.getSourceSc());
			String uniquedWord = tb
					.findFirstWordWithOnlyDiffSymbols(sourceWordsString);
			System.out
					.println("The first word with with only different symbols: "
							+ uniquedWord);
			break;
		case 8:
			sourceWordsString = source.readDataFromInput(lines.getSourceSc());
			String wordPalindrome = tb
					.findSecondNumericWordPalindrome(sourceWordsString);
			System.out.println("The word palindrome is : " + wordPalindrome);
			break;
		case 9:
			System.out.println("Under construction");
			break;
		case 10:
			System.out.println("Under construction");
			break;
		case 11:
			System.out.println("Print matrix 5*5 from 1 to 25:");
			tb.printMatrix(1, 5, 5);
			System.out
					.println("Second invocation of Print matrix 5*5 from 1 to 25:");
			int[][] array = source.fillTwoDArrayWithSymbols(5, 5, 1);
			tb.printMatrixFromTwoDArray(array);
			break;
		case 12:
			double a = 0.0;
			double b = 0.0;
			double c = 0.0;
			try {
				a = Double.parseDouble(args[0]);
				b = Double.parseDouble(args[1]);
				c = Double.parseDouble(args[2]);

			} catch (NumberFormatException e) {
				System.out.println(e);
				System.out.println("Please enter the correct data!");
				System.exit(0);
			}
			QuadraticEquation q = new QuadraticEquation(a, b, c);
			System.out.println("The Quadratic root for computition is: " + a
					+ "*x^2 + " + b + "*x + " + c + " = 0;");

			List<Double> result = q.findRoots();
			final double caseNumber = result.get(0);
			switch ((int) caseNumber) {
			case 0:
				System.out.println("First root(x1): "
						+ String.format("%.3f", result.get(1))
						+ "\nSecond root(x2): "
						+ String.format("%.3f", result.get(2)));
				break;
			case 1:
				System.out.println("Root(x1=x2): "
						+ String.format("%.3f", result.get(1)));
				break;
			case 2:
				String root1 = String.format("%.3f", result.get(1)) + " + i*"
						+ String.format("%.3f", result.get(2));
				String root2 = String.format("%.3f", result.get(1)) + " - i*"
						+ String.format("%.3f", result.get(2));
				System.out.println("First complex root(x1): " + root1 + " \n"
						+ "Second complex root(x2): " + root2);
				break;
			}
			break;
		case 13:
			System.out.println("Please enter the month number: ");
			int month = source.numberWithinRangesChoosing(1, 12,
					lines.getChooseSc());
			System.out.print("The month is: ");
			System.out.println(Month.valueOf(month));
			break;
		}
		lines.close();
		inputSource.close();
	}

	public void close() {
		getSourceSc().close();
		getChooseSc().close();
	}
}
