package com.ICL.TRANSLITTER;


import com.ICL.Input;

public class Transliterator {
    public char[] makeName(){
        Input input = new Input();
        char[] CharName = input.readName();
        return CharName;
    }
}
