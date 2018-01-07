package com.raq.java.concurrent;
//Java program to illustrate Callable
//to return a random number
import java.util.Random;
import java.util.concurrent.Callable;


class CallableExample implements Callable
{

 public Object call() throws Exception
 {
	
     // Create random number generator
     Random generator = new Random();

     Integer randomNumber = generator.nextInt(5);
     System.out.println("Invoking callable with randomNumber ... " + randomNumber);
     // To simulate a heavy computation,
     // we delay the thread for some random time
     Thread.sleep(randomNumber * 5000);
     System.out.println("Returning after execution of callable with randomNumber ... " + randomNumber);
     return randomNumber;
 }
}