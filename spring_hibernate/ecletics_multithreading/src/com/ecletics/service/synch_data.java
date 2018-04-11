package com.ecletics.service;

/**
 *
 * @author duncan
 */
public class synch_data implements Runnable{
    
    @Override
    public void run(){
        for(int counter=0;counter<=10;counter++){
            System.out.println("Thread name: " +Thread.currentThread().getName() + "Thread count: "+counter);
            if (counter==6){
                Thread.currentThread().interrupt();
            }
        }
        
    }
}
