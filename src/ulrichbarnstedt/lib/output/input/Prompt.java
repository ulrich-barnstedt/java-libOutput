package ulrichbarnstedt.lib.output.input;

import java.util.Scanner;

/**
 * Class for prompting user input in a slightly more convenient way
 */
public class Prompt {
    private Scanner scanner = new Scanner(System.in);

    public Prompt () {}

    public Scanner getScanner () {
        return scanner;
    }

    /**
     * Prompt the user for input
     * @param q Prompt message
     * @return Scanner to extract output from
     */
    public Scanner prompt (String q) {
        System.out.print(q + " ");
        return this.scanner;
    }
}
