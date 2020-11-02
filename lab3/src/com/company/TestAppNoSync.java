package com.company;

import java.util.ArrayList;
import java.util.List;

public class TestAppNoSync {

    public static final int N = 10;
    public static final int M = 10;
    private static SharedObject sharedObject;
    private static List<ThreadInc> threadIncList;
    private static List<ThreadDec> threadDecList;

    public static void main(String[] args) {
        long beforeDoing = System.nanoTime();
	    sharedObject = new SharedObject();
	    threadIncList = new ArrayList<>();
	    threadDecList = new ArrayList<>();


	    for (int i =0; i < N; i++){
	        ThreadInc threadInc = new ThreadInc(sharedObject);
	        threadIncList.add(threadInc);
            threadInc.start();
            try {
                threadInc.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

	    for (int j = 0; j < M; j++){
	        ThreadDec threadDec = new ThreadDec(sharedObject);
	        threadDecList.add(threadDec);
	        threadDec.start();
            try {
                threadDec.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
	    System.out.println(sharedObject.getCounter());
        long afterDoing = System.nanoTime();
        long resultTime = afterDoing - beforeDoing;
        double seconds = (double)resultTime / 1000000000.0;

        System.out.println("Result time: " + seconds + " seconds.");
    }
}
