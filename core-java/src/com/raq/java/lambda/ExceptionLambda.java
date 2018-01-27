package com.raq.java.lambda;

import java.util.function.BiConsumer;

public class ExceptionLambda {

	public static void main (String args[]) {
		int[] numArr = {1,2,3,4};
		int key = 0;
			

		//plain
		//process(numArr,key,(a,b)-> System.out.println(a/b));

		//Exception can be handled in the lambda
		/*
		process(numArr,key,(a,b)-> 
		{
			try {
			System.out.println(a/b);
			}catch(Exception ex) {
			  System.out.println(ex.getMessage());
			}
		
		});
		*/
				
		//wrapperLambda overrides the division by sum
		//process(numArr,key,wrapperLambda((a,b)-> System.out.println(a/b)));

		//wrapperLambda returns the same consumer but stil handles the exception in one central place
		process(numArr,key,wrapperLambda((a,b)-> System.out.println(a/b)));
		
	}
	
	
	private static void process(int[] numArr,int key, BiConsumer<Integer, Integer> consumer) {
		for(int i: numArr) {
			//Exception can be handled here,but which one?
			consumer.accept(i, key);
		}
	}

	//wrapperLambda overrides the division by sum
	/*
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (v,k) -> System.out.println(v+k);
	}
	*/

	//wrapperLambda returns a redundant consumer, you could do pre operations
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (v,k) -> 
		{
			try {
			consumer.accept(v, k);
			}catch(Exception ex) {
				System.out.println("Exception caught in the wrapper lambad " + ex.getMessage());
			}
		};
	}
	
	

}
