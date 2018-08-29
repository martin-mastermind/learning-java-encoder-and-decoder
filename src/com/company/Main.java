package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Select mode (1 - encoding, 2 - decoding): ");

        try {
            int selector = Integer.parseInt(reader.readLine());

            switch (selector){
                default:
                    System.out.println("Unknown command");
                    break;
                case 1:
                    enc_mode(reader);
                    break;
                case 2:
                    decr_mode(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void enc_mode(BufferedReader reader){
        Encoder encoder = new Encoder();

        System.out.print("Enter message for encrypting: ");
        String message = "";

        try {
            message = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = encoder.encrypt(message);
        long en_code = encoder.getCode();

        System.out.println("Your message: " + result + "\n\n" + "Hashcode: " + en_code);
    }
    private static void decr_mode(BufferedReader reader){
        long en_code = 0;
        String message = "";

        System.out.print("Enter decrypting code: ");
        try {
            en_code = Long.parseLong(reader.readLine());

            System.out.println();
            System.out.print("Enter encrypted message: ");

            message = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nDecoding in process...");

        Decoder decoder = new Decoder(en_code);
        String decr_message = decoder.decode(message);
        System.out.println("Decoded message: " + decr_message);
    }
}
