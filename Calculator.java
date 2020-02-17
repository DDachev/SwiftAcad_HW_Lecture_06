package bg.swift.HW06;

public class Calculator {

	public static double sum (double a, double b) {
		return a + b;
	}
	
	public static double substract(double a, double b) {
		return a - b;
	}
	
	public static double multiply(double a, double b) {
		return a * b;
	}
	
	public static double divide(double a, double b) {
		if (b != 0) {
			return a / b;
		}
		return -1;
	}
	
	public static double percentage(double a, double b) {
		return (a * b)/100;
	}
	
}
