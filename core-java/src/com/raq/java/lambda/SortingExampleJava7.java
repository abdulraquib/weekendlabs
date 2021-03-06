package com.raq.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExampleJava7 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Abdul","Raafay",12),
				new Person("Mohammad","Shayan",2),
				new Person("Jaffer","Ali",12),
				new Person("Shazreen","Syed",12),
				new Person("Mohammad","Yassir",10),
				new Person("Mohammad","Rishan",4)
				);

	

	//Step 1 : sort list by name
	Collections.sort(people, new Comparator<Person>() {

		@Override
		public int compare(Person p1, Person p2) {
			return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
		}
		
	});
	
	//Step 2 : print all the names in the list
	printAll(people);
	
	//Step 3 : print all the names starting with M
	printFirstNamesStartingwithM(people);
	
	}
	
	
	private static void printAll(List<Person> people) {
		
		for (Person p : people) {
			System.out.println(p);
		}
	}
	
	private static void printFirstNamesStartingwithM(List<Person> people) {

		for (Person p : people) {
			if(p.firstName.startsWith("M")) {
				System.out.println(p);
			}
		}

	}
	
}
