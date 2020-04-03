package com.anotherthreadexample;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CharacterTask implements Runnable{

    Display d;

    @Override
    public void run() {
        d.displayCharacter();
    }
}
