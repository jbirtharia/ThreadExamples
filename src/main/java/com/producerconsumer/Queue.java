package com.producerconsumer;

import lombok.Data;
import java.util.LinkedList;

@Data
public class Queue {

    private LinkedList<Integer> list;

    public Queue() {
        list = new LinkedList<>();
    }
}
