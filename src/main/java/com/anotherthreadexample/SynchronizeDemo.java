package com.anotherthreadexample;

public class SynchronizeDemo {

    public static void main(String[] args) {
        Display d = new Display();
        NumberTask task1 = new NumberTask(d);
        CharacterTask task2 = new CharacterTask(d);

        Thread thread1 = new Thread(task1);
        thread1.start();

        Thread thread2 = new Thread(task2);
        thread2.start();
    }
}
