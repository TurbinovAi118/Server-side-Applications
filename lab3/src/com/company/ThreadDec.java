package com.company;

public class ThreadDec extends Thread{

    public SharedObject sharedObject;

    public ThreadDec(SharedObject sharedObject){
        this.sharedObject = sharedObject;
    }



    @Override
    public void run() {

        synchronized (this) {
            sharedObject.dec();
        }

    }
}

