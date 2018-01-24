package com.raq.java.lambda;

/*
 * Lamdas are functional programming constructs
 * Significantly reduce the number of lines of code
 * Stream API is powerful, allows Asynchronous programming
 */
public class BasicLamdas {
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SomeTest test = () -> System.out.println("Hello");
		test.test();

		MyAdd add = (a,b) -> a + b;
		int c = add.add(10,20);
		System.out.println("Sum " + c);
		
		add = (a,b) -> {
		
			System.out.println("Sum " + (a + b));
			return c;
		};
		add.add(30,40);
	}

}


interface SomeTest{
	void test();
}

interface MyAdd{
	int add ( int a , int b);
	
}