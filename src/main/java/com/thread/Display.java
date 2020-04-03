package com.thread;

public class Display {

    public synchronized void displayMessage(String name){
        for (int i=0; i<5; i++)
        {
            System.out.print("Good morning ");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException exception)
            {
                exception.printStackTrace();
            }
            System.out.println(name);
        }
    }

    public static synchronized void showMessage(String name){
        for (int i=0; i<5; i++)
        {
            System.out.print("Good morning ");
            try {
                Thread.sleep(1);
            }catch (InterruptedException exception)
            {
                exception.printStackTrace();
            }
            System.out.println(name);
        }
    }
}
