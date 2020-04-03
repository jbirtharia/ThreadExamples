package com.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyStaticTask implements Runnable{

    String name;

    @Override
    public void run() {
        Display.showMessage(name);  //static method
    }
}
