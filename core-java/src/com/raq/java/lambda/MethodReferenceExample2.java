package com.raq.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
 * if have a labmda with no input arguments, and calling a method with no input agruments.
 */
public class MethodReferenceExample2 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Abdul","Raafay",12),
				new Person("Mohammad","Shayan",2),
				new Person("Jaffer","Ali",12),
				new Person("Shazreen","Syed",12),
				new Person("Mohammad","Yassir",10),
				new Person("Mohammad","Rishan",4)
				);

	
	
		//printConditionally(people, p -> true, p -> System.out.println(p));

		//Method Refrerence replacing Sytem.out ( Class Name), method Name;
		printConditionally(people, p -> true, System.out::println);

	}
	
	
	//Condition interface replaced with predicate from Java8 Examples
	private static void printConditionally(List<Person> people, Predicate<Person> condition, Consumer<Person> consumer) {

		for (Person p : people) {
			if(condition.test(p)) {
				consumer.accept(p);
			}
		}

	}

}
