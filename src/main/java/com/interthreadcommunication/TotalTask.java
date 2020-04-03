package com.interthreadcommunication;

import lombok.SneakyThrows;

public class TotalTask implements Runnable{

    int total = 0;
    @SneakyThrows
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("child thread start execution..");
            for (int i = 0; i < 10; i++) {
                total = total + i;
            }
            this.notify();
            System.out.println("child thread notifying main thread");
            Thread.sleep(3000);
        }
    }
}
