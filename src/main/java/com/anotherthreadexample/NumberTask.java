package com.anotherthreadexample;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NumberTask implements Runnable{

    Display d;

    @Override
    public void run() {
        d.displayNumber();
    }
}
