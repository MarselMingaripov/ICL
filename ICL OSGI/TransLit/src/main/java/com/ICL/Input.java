package com.ICL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public char[] readName() {
        System.out.println("Vvedite imya na kirillice");
        String name = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            name = bufferedReader.readLine();
            if (name.length() == 0){
                System.out.println("Imya ne vvedeno");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] CharNameArrayname = name.toCharArray();
        return CharNameArrayname;
    }
}
