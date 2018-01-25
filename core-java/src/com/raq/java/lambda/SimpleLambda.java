package com.raq.java.lambda;

public class SimpleLambda {

	public static void main(String args[]) {
		//Lamda with simple one line statement
		SomeTest test = () -> System.out.println("Hello");
		test.test();

		//Lamda with simple multi line statement
		test = () -> {
			for(int i=0;i<3;i++) {
				System.out.println("Hello " + i);
			}
			
		};
		test.test();
		
		//Thread with Lambda implementing Runnable
		Thread t = new Thread(()->System.out.println("Running inside runnable"));
		t.start();

	}
	
}


interface SomeTest{
	void test();
}
