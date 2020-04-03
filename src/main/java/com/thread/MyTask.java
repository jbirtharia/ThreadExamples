package com.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyTask implements Runnable{

    Display display;
    String name;

    @Override
    public void run() {
        //display.displayMessage(name);
        Display.showMessage(name);  //static method
    }
}
