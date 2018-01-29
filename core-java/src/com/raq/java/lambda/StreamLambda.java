package com.raq.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Stream allows filter data, like a decorator pattern
 * Stream inputs are lambdas
 * parallel streams allow multiple cores to process the streams in parallel. 
 * Ref: javabrains.io
 * Ref: http://tutorials.jenkov.com/java-collections/streams.html#stream-map
 * Ref: https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
 * Ref : https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 */
public class StreamLambda {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Abdul","Raafay",12),
				new Person("Mohammad","Shayan",2),
				new Person("Jaffer","Ali",12),
				new Person("Shazreen","Syed",12),
				new Person("Mohammad","Yassir",10),
				new Person("Mohammad","Rishan",4)
				);


		
		System.out.println("Iteration using lambda for each loop using stream ...");
		
		//https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
		people.stream()
		.filter(p->p.getFirstName().startsWith("M"))
		.forEach(p->System.out.println(p));
		
		long count = people.stream()
		.filter(p->p.getFirstName().startsWith("M")) //returns a stream, like a pipe / decorator
		.count(); // terminal operation
		
		System.out.println(count);
		
		count = people.parallelStream()
		.filter(p->p.getFirstName().startsWith("M")) //returns a stream, like a pipe / decorator
		.count(); // terminal operation
		System.out.println(count);
		
		
		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		items.stream().map(i->i.toUpperCase()).forEach(i->System.out.println(i));
	
		
		people.stream()
		.map(p-> new Person(p.getFirstName().toUpperCase(),p.getLastName().toUpperCase(),p.getAge()))
		.forEach(p->System.out.println(p));
		
		//TBD Reduce
	  	  int[] array = {23,43,56,97,32};
	  	  /*
	  	   * T result = identity;
		     for (T element : this stream)
		         result = accumulator.apply(result, element)
		     return result;
	  	   */
	  	  Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
	  	  Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
	  	  Arrays.stream(array).reduce(StreamLambda::addIntData).ifPresent(s -> System.out.println(s));
  	  

	}

	public static int addIntData(int num1, int num2) {
		return num1 + num2;
	}
}
