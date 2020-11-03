package com.company;

public class ThreadDec extends Thread{


    //NoSync
    //public SharedObject sharedObject;
    //public ThreadDec(SharedObject sharedObject){
    //   this.sharedObject = sharedObject;
    //}

    @Override
    public void run() {

        //NoSync
        //sharedObject.dec();

        //Sync
        //for (int i = 0; i < SyncTestApp.M; i++) {
        //    SyncTestApp.dec();
        //}

        //ReentrantLock
        for (int i = 0; i < ReentrantLockTestApp.M; i++) {

            ReentrantLockTestApp.dec();

        }

    }
}

