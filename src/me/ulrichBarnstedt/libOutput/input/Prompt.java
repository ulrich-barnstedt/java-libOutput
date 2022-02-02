package me.ulrichBarnstedt.libOutput.input;

import java.util.Scanner;

public class Prompt {
    private Scanner scanner = new Scanner(System.in);

    public Prompt () {}

    public Scanner getScanner () {
        return scanner;
    }

    public Scanner prompt (String q) {
        System.out.print(q + " ");
        return this.scanner;
    }
}
