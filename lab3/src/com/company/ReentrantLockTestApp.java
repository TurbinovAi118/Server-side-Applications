package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTestApp {
    private static int counter;

    public static final int N = 1000;
    public static final int M = 1000;

    public static void main(String[] args) {
        long beforeDoing = System.nanoTime();

        Thread threadInc = new Thread(new ThreadInc());
        Thread threadDec = new Thread(new ThreadDec());

        threadInc.start();
        threadDec.start();

        try {
            threadInc.join();
            threadDec.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(counter);
        long afterDoing = System.nanoTime();
        long resultTime = afterDoing - beforeDoing;
        double seconds = (double)resultTime / 1000000000.0;

        System.out.println("Result time: " + seconds + " seconds.");
    }

    public static void inc(){
        counter++;
    }

    public static void dec() {

        Lock lock = new ReentrantLock();
        lock.lock();
        counter--;
        lock.unlock();

    }
}
