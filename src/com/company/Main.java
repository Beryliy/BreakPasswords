package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BreakPassword breakPassword = new BreakPassword(
                3,
                new char[]{'a', 'b', 'c'},
                "passwords.txt"
                );
        breakPassword.generateAllPasswords();
    }
}
