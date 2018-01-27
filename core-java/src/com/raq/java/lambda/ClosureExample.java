package com.raq.java.lambda;

public class ClosureExample {
	
 public static void main (String args[]) {
		int a = 10;
		final int b = 20;

		//closure with anonymous function
		/*
		doProcess(a,new Process() {

			@Override
			public void process(int i) {
				// pass variable b as closure
				System.out.println(i+b);
				
			}
			
		});
	   */
		
		//closure with lambda function
		doProcess(a, i -> System.out.println(i+b));
		
	 
 }
 
 public static void doProcess(int i, Process p) {
	 p.process(i);
 }
	
	
}


interface Process {
	void process(int i);
}