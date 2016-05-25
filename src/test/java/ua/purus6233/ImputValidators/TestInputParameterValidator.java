package ua.purus6233.ImputValidators;

import org.junit.Assert;
import org.junit.Test;

public class TestInputParameterValidator extends Assert {
	
	@Test
	public void test_type() throws Exception {
		assertNotNull(InputParameterValidator.class);
	}
	
	@Test
	public void test_instantiation() throws Exception {
		InputParameterValidator target = new InputParameterValidator();
		assertNotNull(target);
	}
	
	@Test
	public void test_checkWithRegExp(){
		InputParameterValidator validator = new InputParameterValidator();
		String latinPattern = "^[a-zA-Z]+$";
		String numericPattern = "^[0-9]+$";
		validator.setPatternExpresion(latinPattern);
		
		boolean actual = validator.checkWithRegExp("latinLatin");
	    assertTrue(actual);
	    	    
	    actual = validator.checkWithRegExp("русский");
	    assertFalse(actual);
	    
	    validator.setPatternExpresion(numericPattern);
		
		actual = validator.checkWithRegExp("latin");
	    assertFalse(actual);
	    
	    actual = validator.checkWithRegExp("12354");
	    assertTrue(actual);
	    
	}
	
	@Test
	public void test_isVowel(){
		InputParameterValidator validator = new InputParameterValidator();
		
		boolean actual = validator.isVowel('a');
	    assertTrue(actual);
	    
	    actual = validator.isVowel('Z');
	    assertFalse(actual);
	    
	    actual = validator.isVowel('1');
	    assertFalse(actual);
	}
	
	@Test
	public void test_isPalindrome(){
		InputParameterValidator validator = new InputParameterValidator();
		
		boolean actual = validator.isPalindrome("1235321");
	    assertTrue(actual);
	    
	    actual = validator.isPalindrome("abcba");
	    assertTrue(actual);
	    
	    actual = validator.isPalindrome("123654");
	    assertFalse(actual);
	}
}
