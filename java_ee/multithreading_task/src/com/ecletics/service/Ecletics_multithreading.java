package com.ecletics.service;

/**
 *
 * @author duncan
 */
public class Ecletics_multithreading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        synch_data sdObj=new synch_data();
        //create 4 unique threads.
        for (int x=0; x<=3;x++){
            new Thread(new synch_data()).start();
        }
        
    }
    
}
