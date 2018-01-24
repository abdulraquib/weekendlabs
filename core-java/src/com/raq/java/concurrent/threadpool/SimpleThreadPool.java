package com.raq.java.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ava thread pool manages the pool of worker threads, it contains a queue that keeps tasks waiting to get executed.
 * We can use ThreadPoolExecutor to create thread pool in java
 * 
 * @author araquib
 * Ref : https://www.journaldev.com/1069/threadpoolexecutor-java-thread-pool-example-executorservice
 * Ref : https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ThreadPoolExecutor.html
 * Ref : https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html
 */
public class SimpleThreadPool {

    public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerTask("" + i);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        	
        }
    	long endTime = System.currentTimeMillis();
        System.out.println("Finished all threads  in " + (endTime-startTime) +" millis");
        
    }
}