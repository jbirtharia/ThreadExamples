package com.interthreadcommunication;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        TotalTask task = new TotalTask();

        Thread thread = new Thread(task);
            thread.start();
        synchronized (thread){
            System.out.println("main thread get into waiting state..");
            thread.wait();
            System.out.println("Main thread get notification..");
        }
        System.out.println("Total result is : "+task.total);
    }
}
