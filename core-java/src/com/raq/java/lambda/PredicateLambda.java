package com.raq.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class PredicateLambda {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Abdul","Raafay",12),
				new Person("Mohammad","Shayan",2),
				new Person("Jaffer","Ali",12),
				new Person("Shazreen","Syed",12),
				new Person("Mohammad","Yassir",10),
				new Person("Mohammad","Rishan",4)
				);

	

	
	Collections.sort(people, (p1,p2) -> p1.getFirstName().compareToIgnoreCase(p2.getFirstName()) );

	//Step 2 : print all the names in the list
	printConditionally(people, p -> true);

	
	//Step 3 : print all the names starting with M
	printConditionally(people, p -> p.firstName.startsWith("M"));

	}
	
	
	//Condition interface replaced with predicate from Java8 Examples
	private static void printConditionally(List<Person> people, Predicate<Person> condition) {

		for (Person p : people) {
			if(condition.test(p)) {
				System.out.println(p);
			}
		}

	}
	
}

