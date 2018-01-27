package com.raq.java.lambda;

/*
 * if have a labmda with no input arguments, and calling a method with no input agruments.
 */
public class MethodReferenceExample1 {

	public static void main(String args[]) {
		/*
		Thread t = new Thread(()->printMessage());
		t.start();
		*/

		Thread t = new Thread(MethodReferenceExample1::printMessage);
		t.start();

	}
	
	
	
	private static void printMessage() {
		System.out.println("Hello");
	}
}
