package com.producerconsumer;

import lombok.SneakyThrows;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {

        Queue queue = new Queue();

        Thread producerThread = new Thread(() -> {
            new Producer().produce(queue.getList());
        });
        producerThread.start();

        Thread.sleep(1000);
        Thread consumerThread = new Thread(() -> {
            new Consumer().consume(queue.getList());
        });
        consumerThread.start();

    }
}
