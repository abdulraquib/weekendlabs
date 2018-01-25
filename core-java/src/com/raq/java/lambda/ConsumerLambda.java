package com.raq.java.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class ConsumerLambda {

	public static void main(String args[]) {
		//Lamda with simple one line statement
		Performer performer1 = s -> System.out.println("peforming activity " + s);
		performer1.perform("Dance");
		
		Consumer<String> performer2 = s -> System.out.println("peforming activity " + s);
		performer2.accept("Dance");

		//performer2.andThen(performer2).accept("Sing");
		
		BiConsumer<String,String> performer3 = (a,b) -> {
			System.out.println("peforming activity " + a + " and " + b);
		};
		
		performer3.accept("Sing", "Dance");
		
		DoubleConsumer performer4 = i -> System.out.println("peforming activity no " + i);
		performer4.accept(10);
		
		
	}
	
}

//FunctionalInterface annotation Ensures that there is only one function in this interface
@FunctionalInterface
interface Performer{
	void perform(String activity);
}
