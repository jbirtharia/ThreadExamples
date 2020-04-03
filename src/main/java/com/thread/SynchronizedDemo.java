package com.thread;

public class SynchronizedDemo {

    public static void main1(String[] args) {
        Display display = new Display();
        //Regular output because displayMessage() method is synchronized
        MyTask myTask1 = new MyTask(display, "Dhoni");
        Thread thread1 = new Thread(myTask1);
        thread1.start();

        MyTask myTask2 = new MyTask(display, "Yuvraj");
        Thread thread2 = new Thread(myTask2);
        thread2.start();
    }

    public static void main2(String[] args) {
        Display display1 = new Display();
        Display display2 = new Display();

        //Irregular output because displayMessage() method is synchronized and two threads are working on separate object
        MyTask myTask1 = new MyTask(display1, "Dhoni");
        Thread thread1 = new Thread(myTask1);
        thread1.start();

        //For instance synchronized method thread will apply object level lock
        MyTask myTask2 = new MyTask(display2, "Yuvraj");
        Thread thread2 = new Thread(myTask2);
        thread2.start();
    }

    public static void main(String[] args) {
        Display display = new Display();

        //For static synchronized method thread will apply class level lock
        MyStaticTask myTask1 = new MyStaticTask("Dhoni");
        Thread thread1 = new Thread(myTask1);
        thread1.start();

        MyStaticTask myTask2 = new MyStaticTask("Yuvraj");
        Thread thread2 = new Thread(myTask2);
        thread2.start();

        MyStaticTask myTask3 = new MyStaticTask("Kohli");
        Thread thread3 = new Thread(myTask3);
        thread3.start();
    }
}
