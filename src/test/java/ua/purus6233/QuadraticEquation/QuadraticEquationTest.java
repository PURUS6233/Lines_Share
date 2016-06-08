package ua.purus6233.QuadraticEquation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuadraticEquationTest extends Assert {
	
	private QuadraticEquation data_1;
	private QuadraticEquation data_2;
	private QuadraticEquation data_3;
	private QuadraticEquation data_4;
	private static final double [] expected_1 = {0.0,-0.209,-4.791};
	private static final double [] expected_2 = {1.0,-1.0};
		
	@Before
	public void setUpBeforeTest(){
	data_1 = new QuadraticEquation(1,5,1);
	data_2 = new QuadraticEquation(1,2,1);
	//illegal cases
	data_3 = new QuadraticEquation(0,1.23,1.23);
	data_4 = new QuadraticEquation(-20.126,0,0);
	}
	
	@After
	public void tearDownAfterTest(){
	data_1 = null;
	data_2 = null;
	data_3 = null;
	data_4 = null;
	}
	
	@Test
	public void test_type() throws Exception {
		assertNotNull(QuadraticEquation.class);
	}
	
	@Test
	public void test_instantiation() throws Exception {
		QuadraticEquation target = new QuadraticEquation();
		assertNotNull(target);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_findRootsWithIllegal_A_Param(){
		data_3.findRoots();
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_findRootsWithIllegal_B_C_Param(){
		data_4.findRoots();
	}
	
	@Test
	public void test_findRoots_data_1(){
		
		List<Double> actualList_1 = data_1.findRoots();
		double actual_1[] = new double[actualList_1.size()];
		for(int i=0; i<actualList_1.size(); i++){
			actual_1[i] = (double)actualList_1.get(i);
		}
		assertArrayEquals(expected_1, actual_1, 0.01);
	}
	@Test
	public void test_findRoots_data_2(){
		List<Double> actualList_2 = data_2.findRoots();
		double actual_2[] = new double[actualList_2.size()];
		for(int i=0; i<actualList_2.size(); i++){
			actual_2[i] = (double)actualList_2.get(i);
		}
		assertArrayEquals(expected_2, actual_2,0.01);
	}
}
