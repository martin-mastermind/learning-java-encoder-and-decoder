package com.company;

public class Decoder {
    private long private_code;

    Decoder(long code){
        this.private_code = code;
    }

    String decode(String en_message){
        StringBuilder result = new StringBuilder();

        for(char en_letter : en_message.toCharArray()) {
            result.append((char) (en_letter - (this.private_code % 10) - 3));
        }

        return result.toString();
    }
}
