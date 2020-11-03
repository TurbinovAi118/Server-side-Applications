package com.company;

public class ThreadInc extends Thread{

    //NoSync
    //private SharedObject sharedObject;
    //public ThreadInc(SharedObject sharedObject){
    //    this.sharedObject = sharedObject;
    //}


    @Override
    public void run() {

        //NoSync
        //sharedObject.inc();

        //Sync
        //for (int i = 0; i < SyncTestApp.N; i++) {
        //    SyncTestApp.inc();
        //}

        //ReentrantLock
        for (int i = 0; i < ReentrantLockTestApp.N; i++) {

            ReentrantLockTestApp.inc();

        }

    }
}
