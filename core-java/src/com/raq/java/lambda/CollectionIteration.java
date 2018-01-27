package com.raq.java.lambda;

import java.util.Arrays;
import java.util.List;

public class CollectionIteration {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Abdul","Raafay",12),
				new Person("Mohammad","Shayan",2),
				new Person("Jaffer","Ali",12),
				new Person("Shazreen","Syed",12),
				new Person("Mohammad","Yassir",10),
				new Person("Mohammad","Rishan",4)
				);


		System.out.println("Iteration using basic forloop ...");
		for(int i =0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("Iteration using enhanced for each loop ...");
		for(Person p: people) {
			System.out.println(p);
		}
		
		
		System.out.println("Iteration using lambda for each loop ...");
		people.forEach(p->System.out.print(p));
		
		System.out.println("Iteration using lambda for each loop method referecnce ...");
		people.forEach(System.out::println);

	}

}
