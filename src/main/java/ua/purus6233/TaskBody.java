package ua.purus6233;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;

import ua.purus6233.ImputValidators.InputParameterValidator;
import ua.purus6233.Sort.StringLengthComparator;

enum Order {
	ASCENDING('>'), DESCENDING('<');
	
	private char orderSign;
	
	private Order(char orderSign){
		this.orderSign = orderSign;
	}
	
	public static Order getOrder(char order){
		for(Order or: Order.values()){
			if (or.orderSign == order){
				return or;
			}
		}
		throw new IllegalArgumentException("Order sign not correct.");
	}
}

enum Month {
	JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
	JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);
	
	private int monthCode;
	
	private static Map<Integer, Month> map = new HashMap<Integer, Month>();
	static {
		for (Month monthEnum : Month.values()) {
			map.put(monthEnum.monthCode, monthEnum);
			}
		}
	
	private Month(int monthCode){
		this.monthCode = monthCode;
	}
	
	public static Month valueOf(int monthCode){
		if (map.containsKey(monthCode)){
			return map.get(monthCode);
		}
		throw new IllegalArgumentException("Month number not correct.");
	}
}

public class TaskBody {
	
	public List<String> createSubList(List<String> list, int fromIndex, int tillIndex){
		
		List<String> partList; 
		Preconditions.checkArgument(!((fromIndex<0||tillIndex<0)||fromIndex>tillIndex), "Please choose correct diapazon! from:[%s], till:[%s]",fromIndex, tillIndex);
		partList = list.subList(fromIndex, tillIndex);
		
		return partList;
	}
	
	public List<String> findShortLongSentence(List<String> list) {
		
		List<String> shortLong = new ArrayList<>();
		String shortest = list.get(0);
		String longest = list.get(0);
		
		for(String sentence: list){
			if(sentence.length()<shortest.length()){
				shortest = sentence;
			}
			else if(sentence.length()>longest.length()){
				longest = sentence;
			}
		}
		shortLong.add("Shortest sentence: " + shortest + 
				" (" + shortest.length() + ")");
		shortLong.add("Longest sentence: " + longest + 
				" (" + longest.length() + ")");
		return shortLong;
	}
	StringLengthComparator sc = new StringLengthComparator();
	
	public List<String> orderSelection(List<String> list, Order orderSighn){
		
		List<String> copyList = new ArrayList<String>(list);//This is the shallow copy
		Collections.copy(copyList, list);
				
		switch(orderSighn){
		case ASCENDING: 
			Collections.sort(copyList, sc);//TODO Why we need it?
			break;
		case DESCENDING:
			Collections.sort(copyList, sc);
			Collections.reverse(copyList);
		}
		
		return copyList;
	}
	
	public List<String> findRequiredPart(List<String> list,Order order){
		
		List<String> listPart = new ArrayList<String>(list);//This is the shallow copy
		Collections.copy(listPart, list);
		List<String> orderedList = orderSelection(listPart, Order.ASCENDING);
		
		final int listMiddle = (listPart.size())/2;
		if (order == Order.DESCENDING){
			listPart = createSubList(orderedList, 0, listMiddle);
			return listPart;
		}
		else if (order == Order.ASCENDING){
			listPart = createSubList(orderedList, listMiddle, list.size());
			return listPart;
		}
		throw new RuntimeException();
	}
	
	public String findFirstWordWithMinimumDifferentSymbols(List<String> list){
		int uniquenessFactor = 0;
		String requiredWord = "";
		for(String word: list){
			Set<Character> set = new HashSet<Character>();
			int wordLength = word.length();
			//for(int i=0;i<word.length();i++){ //Second approach
			//	set.add(word.charAt(i)); 
			for(char ch: word.toCharArray()){
				set.add(ch);
			}
			int setSize = set.size();
			int uniqFac = wordLength/setSize;
			if(uniquenessFactor<uniqFac){
				uniquenessFactor=uniqFac;
				requiredWord = word;
			}
		}
		return requiredWord;
	}
	
	InputParameterValidator validator = new InputParameterValidator();
	
	private static final String LATINPATTERN = "^[a-zA-Z]+$";
	
	public List<String> findLatinCharWords(List<String> list){
		List<String> latinWords = new ArrayList<String>();
		boolean valid;
		validator.setPatternExpresion(LATINPATTERN);
		
		for(String word: list){
			valid = validator.checkWithRegExp(word);
			if (valid){
				latinWords.add(word);
			}
		}
		return latinWords;
	}
	
	public int counterEqualConsVovelWords(List<String> latinWords){ // FIXME
		int equalVovConsNumber = 0;
		double rateEquality = 2.0;
		double vovConsRate = 0.0;
		
		for(String word: latinWords){
			double vovelCounter = 0;
			for(int i=0;i<word.length();i++){
				if (validator.isVowel(word.charAt(i))){
					vovelCounter++;
				}
			}
			vovConsRate = (word.length())/vovelCounter;
			int rateValue = Double.compare(vovConsRate, rateEquality);
			if(!(rateValue>0 || rateValue<0)) {
				equalVovConsNumber++;
		     }
		}
		return equalVovConsNumber;
	}
	
	public String findFirstWordWithCharCodeAscOrder(List<String> list){
		String requaredWord = "";
		labelFor:
		for (String word: list){
			for(int i=1;i<word.length();i++){
				if(word.charAt(i-1)>word.charAt(i)||word.charAt(i-1)==word.charAt(i)){
					break;
				}
				if(i==word.length()-1){
					requaredWord = word;
					break labelFor;
				}
			}
		}
		return requaredWord;
	}
	
	public String findFirstWordWithOnlyDiffSymbols (List<String> list){
		String requiredWord = "";
		labelFor:
		for(String word: list){
			Set<Character> set = new HashSet<Character>();
			int wordLength = word.length();
			for(int i=0;i<word.length();i++){
				set.add(word.charAt(i));
			}
			int setSize = set.size();
			int uniqFactor = wordLength/setSize;
			if(uniqFactor==1){
				requiredWord = word;
				break labelFor;
			}
		}
		return requiredWord;
	}
	
	private static final String PALINDROME_PATTERN = "^[0-9]+$";
	
	public String findSecondNumericWordPalindrome (List<String> list){
		List<String> palindromeList = new ArrayList<String>();
		validator.setPatternExpresion(PALINDROME_PATTERN);
		String wordPalindrome = "";
		
		for (String word: list){
			boolean valid = validator.checkWithRegExp(word);
			boolean isPalindrome = validator.isPalindrome(word);
			if (valid && isPalindrome){
				palindromeList.add(word);				
			}
		}
		if (palindromeList.size() > 1){
			wordPalindrome = palindromeList.get(1);
		}
		else{
			try{
				wordPalindrome = palindromeList.get(0);	
			}catch(IndexOutOfBoundsException e){
				wordPalindrome = "There is no Numeric Palindrome word in the source.";
			}
		}
		return wordPalindrome;
	}
	
	public void printMatrix(int first, int lines, int rows){
		int matrixLen = lines*rows;
		
		for(int i=1;i<=matrixLen;i++){
			System.out.print (i + " ");
			if(i%rows==0){
				System.out.println();
			}
		}
	}
	
	public void printMatrixFromTwoDArray(int[][] matrix){
		for(int[]a:matrix){
			for(int i:a){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
