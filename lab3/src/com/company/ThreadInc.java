package com.company;

public class ThreadInc extends Thread{

    private SharedObject sharedObject;

    public ThreadInc(SharedObject sharedObject){
        this.sharedObject = sharedObject;
    }


    @Override
    public void run() {

        sharedObject.inc();



    }
}
