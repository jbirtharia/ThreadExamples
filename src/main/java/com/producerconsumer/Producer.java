package com.producerconsumer;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Random;

public class Producer {

    @SneakyThrows
    public void produce(LinkedList<Integer> list){
        int value = 0 ;
        while (true) {
            synchronized (this) {
                while (!list.isEmpty())
                    wait();
                list.add(++value);
                System.out.println("Producing : "+(value));
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
