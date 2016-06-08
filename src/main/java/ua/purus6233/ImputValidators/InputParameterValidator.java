package ua.purus6233.ImputValidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;  

public class InputParameterValidator {
	private String patternExpresion;  
	
	public void setPatternExpresion(String exp){
		this.patternExpresion = exp;
	}
	
	public String getPatternExpresion(){
		return patternExpresion;
	}   
	   /**  
	    * Validate customer input depending on regular expression  
	    * @param source. Input source address for validation  
	    * @return true valid customer input, false invalid customer input  
	    */
	 
	public boolean checkWithRegExp(final String source){ 
		Pattern p = Pattern.compile(getPatternExpresion());
        Matcher m = p.matcher(source);
		return m.matches();
	}
	
	public boolean isVowel(char ch){
		if(ch == 'a'||ch =='A'||ch =='e'||ch =='E'||ch =='i'||ch =='I'||ch =='o'
				||ch =='O'||ch =='u'||ch =='U'||ch =='y'||ch =='Y'){
			return true;
		}else{
			return false;
		}
	}

	/**public boolean isWordPalindrome(String word){
		StringBuilder wordB = new StringBuilder(word);
		if (wordB.equals(wordB.reverse())){
			return true;			
		}
		else{
			return false;
		}
	}*/
	
	public boolean isPalindrome(String word){
		String wordCase = word.toLowerCase();
		StringBuilder reverseWordSB = new StringBuilder(wordCase);
		reverseWordSB.reverse();
				
		String reverceWordSt = reverseWordSB.toString();
		return wordCase.equals(reverceWordSt);
	}
}
