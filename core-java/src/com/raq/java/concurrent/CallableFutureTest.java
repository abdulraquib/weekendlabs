package com.raq.java.concurrent;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * The need for Callable
 * 
 * There are two ways of creating threads – one by extending the Thread class and other by creating a thread with a Runnable. However, one feature lacking in  Runnable is that we cannot make a thread return result when it terminates,
 * i.e. when run() completes. For supporting this feature, the Callable interface is present in Java.
 * 
 * Callable vs Runnable
 * 
 *    For implementing Runnable, the run() method needs to be implemented which does not return anything, 
 *    while for a Callable, the call() method needs to be implemented which returns a result on completion. 
 *    Note that a thread can’t be created with a Callable, it can only be created with a Runnable.
 *    Another difference is that the call() method can throw an exception whereas run() cannot.
 * 
 * reference : https://www.geeksforgeeks.org/callable-future-java/
 * @author araquib
 *
 */
public class CallableFutureTest
{
  @SuppressWarnings("unchecked")
public static void main(String[] args) throws Exception
  {
 
    // FutureTask is a concrete class that
    // implements both Runnable and Future
    FutureTask[] randomNumberTasks = new FutureTask[5];
 
    for (int i = 0; i < 5; i++)
    {
      @SuppressWarnings("rawtypes")
	Callable callable = new CallableExample();
 
      // Create the FutureTask with Callable
      randomNumberTasks[i] = new FutureTask(callable);
 
      // As it implements Runnable, create Thread
      // with FutureTask
      Thread t = new Thread(randomNumberTasks[i]);
      t.start();
      System.out.println("randomNumberTasks["+i+"].isDone().." + randomNumberTasks[i].isDone());
      if(i == 3) {
    	  randomNumberTasks[i].cancel(true);
      }
    }
 
    for (int i = 0; i < 5; i++)
    {
    	  System.out.println("randomNumberTasks["+i+"].isDone().." + randomNumberTasks[i].isDone());
    	  System.out.println("randomNumberTasks["+i+"].isCancelled().." + randomNumberTasks[i].isCancelled());
    	  
      // As it implements Future, we can call get()
      System.out.println(randomNumberTasks[i].get());
 
      // This method blocks till the result is obtained
      // The get method can throw checked exceptions
      // like when it is interrupted. This is the reason
      // for adding the throws clause to main
    }
  }
}
