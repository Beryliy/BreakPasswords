package com.company;

import java.io.*;

public class BreakPassword {
    private String filename;
    private int passwordLength;
    private char [] alphabet;

    public BreakPassword(int passwordLength, char[] alphabet, String filename){
        this.passwordLength = passwordLength;
        this.alphabet = alphabet;
        this.filename = filename;
    }

    public void generateAllPasswords() {
        File file = new File(filename);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for(int i = 1; i <= passwordLength; i++) {
                generatePassword(new char[i], 0, bufferedWriter);
            }
            bufferedWriter.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void generatePassword(char[] password, int position, BufferedWriter bufferedWriter) {
        for(char symbol : alphabet) {
            password[position] = symbol;
            if(position != password.length - 1) {
                generatePassword(password, position + 1, bufferedWriter);
            } else {
                try {
                    bufferedWriter.write(password, 0, password.length);
                    bufferedWriter.write('\n');
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
