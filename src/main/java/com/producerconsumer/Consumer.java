package com.producerconsumer;

import lombok.SneakyThrows;

import java.util.LinkedList;

public class Consumer {

    @SneakyThrows
    public void consume(LinkedList<Integer> list) {
        while (true) {
            synchronized (this) {
                while (list.isEmpty())
                    wait();
                System.out.println("Consuming : " + list.getFirst());
                list.removeFirst();
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
