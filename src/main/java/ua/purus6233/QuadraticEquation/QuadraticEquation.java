package ua.purus6233.QuadraticEquation;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;

public class QuadraticEquation{
	
	private double a; //firstCoefficient 
	private double b; //secondCoefficient
	private double c; //freeMember
	private double D; //Discriminant
	private double x1;//first root
	private double x2;//second root
	
	public QuadraticEquation(){
	}
	
	public QuadraticEquation(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double getA(){
	    return a;
	}
	public void setA(double a){
	    this.a = a;
	}
	
	public double getB(){
	    return b;
	}
	public void setB(double b){
	    this.b = b;
	}
	
	public double getC(){
	    return c;
	}
	public void setC(double c){
	    this.c = c;
	}
	
	public void checkForSolvingPossibility(){
		Preconditions.checkArgument(!(getA()==0.0), "Quadratic equation can't be solved! Coefficient a != 0");
		Preconditions.checkArgument(!(getB()==0&&getC()==0), "Quadratic equation can't be solved! Both Coefficients b & c != 0");
	}
	
	public List<Double> findRoots(){
		checkForSolvingPossibility();
		if(getB()==0&&getC()!=0){
			D = - 4*getA()*getC();
			return rootDefinition(D);
		}
		if(getB()!=0&&getC()==0){
			D = Math.pow(getB(),2);
			return rootDefinition(D);
		}
		D = Math.pow(getB(),2)-4*getA()*getC();
		return rootDefinition(D);
	}

	public List<Double> rootDefinition(double D) { 
		List<Double> result = new ArrayList<Double>();
		
		if(D>0){
			result.add(0.0);
			System.out.println("There are two distinct roots:");
			x1 = (-b + Math.sqrt(D))/(2*a);
			result.add(x1);
			x2 = (-b - Math.sqrt(D))/(2*a);
			result.add(x2);	
		}else if(D==0){
			result.add(1.0);
			System.out.println("There is only one distinct root:");
			x1=x2 = (-b)/(2*a);
			result.add(x1);
		}else{
			result.add(2.0);
			System.out.println("This equation has no distinct roots! \n"
					+ "It contains only complex roots.");
			x1 = -b/(2*a);
			result.add(x1);
			x2 = Math.sqrt(Math.abs(D))/(2*a);
			result.add(x2);
			
		}
		return result;
	}
}