package com.raq.java.lambda;

/*
 * Lamdas are functional programming constructs
 * Significantly reduce the number of lines of code
 * Stream API is powerful, allows Asynchronous programming
 * The functional Interface needs to have only one function
 * The Java8 Compiler checks for the arguments
 * basically, compare the interface type, and parameters and provide implementation
 * Different than anonymous inner class
 * 
 * @Refer
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
public class BasicLamdas {
	
	
	//works on the analysis of matching the arguments as opposed to the name of the function.
	
	public static void main(String[] args) {
		
		//Anonymous Add function
		MyAdd anonymousAdd = new MyAdd() {

			@Override
			public int add(int a, int b) {
				int c = a + b;
				System.out.println(" Anonymous Sum " + c);
				return 0;
			}
			
		};
		
		anonymousAdd.add(40, 50);



		//Lamda with simple one line statement
		MyAdd add = (a,b) -> a + b;
		int c = add.add(10,20);
		System.out.println("Sum " + c);

		//Lamda with  multi line statements, 
		//@see runtime polymorphism
		add = (a,b) -> {
		
			System.out.println("Sum " + (a + b));
			return c;
		};
		add.add(30,40);
		
	}

}



interface MyAdd{
	int add ( int a , int b);
	
}