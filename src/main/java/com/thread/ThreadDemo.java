package com.thread;

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("Child Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted...");
            }
        }
    }
}

public class ThreadDemo{

    static Thread mainThread;

    public static void main1(String[] args) {
        // Creating thread using Thread class
        MyThread myThread = new MyThread();
        /* start() method is responsible to create a new thread. If we call directly run method then it will be
        * normal method call. That will no create any new thread.*/
        myThread.start();
        //myThread.run();

        for (int i=0; i<5; i++)
            System.out.println("Main Thread");
    }

    public static void main2(String[] args) {
        // Creating thread using Runnable interface
        // Here thread is creating by passing Runnable interface to Thread class
        Thread thread = new Thread(() -> {                  //Implementation of run method of Runnable interface
            for (int i=0; i<5; i++)
                System.out.println("Child Thread");
        });
        thread.start();

        for (int i=0; i<5; i++)
            System.out.println("Main Thread");
    }

    public static void main3(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i=0; i<5; i++) {
                System.out.println("Child Thread");
                /* Thread.yield() method pauses current flow of thread
                 * and give chance to other thread with higher priority or same priority.
                 * If there is no thread with higher or same priority then same thread will execute */
                Thread.yield();

            }
        });
        thread.start();
        for (int i=0; i<5; i++)
            System.out.println("Main Thread");   // Due to yield() method main will always execute first.
    }

    public static void main4(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i=0; i<5; i++) {
                System.out.println("Child Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join(1000);      //thread will wait for 1000 milli seconds
        for (int i=0; i<5; i++)
            System.out.println("Main Thread");
    }

    public static void main5(String[] args) throws InterruptedException {
        mainThread=Thread.currentThread();
        Thread thread = new Thread(() -> {
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0; i<5; i++) {
                System.out.println("Child Thread");
            }
        });
        thread.start();
        for (int i=0; i<5; i++)
        {
            System.out.println("Main Thread");
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
            for (int i=0; i<5; i++) {
                System.out.println("Child Thread");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted...");
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println("End of main...");
    }
}
