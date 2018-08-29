package com.company;

import java.util.Calendar;

class Encoder {
    private Calendar current;

    Encoder(){
        current = Calendar.getInstance();
    }

    String encrypt(String message){
        StringBuilder result = new StringBuilder();

        for(char letter : message.toCharArray()){
            result.append((char) (letter + (this.current.getTimeInMillis() % 10) + 3));
        }

        return result.toString();
    }

    long getCode(){
        return this.current.getTimeInMillis();
    }
}
