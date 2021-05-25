package ir.ac.kntu;

import java.util.Scanner;


public class ScannerWrapper {
    private static ScannerWrapper instance = new ScannerWrapper();

    private Scanner scanner;

    public static ScannerWrapper getInstance() {
        return instance;
    }

    private ScannerWrapper() {
        scanner = new Scanner(System.in);
    }

    public int nextInt() {
        int choice = scanner.nextInt();
        scanner.skip("\n");
        return choice;
    }

    public double nextDouble() {
        return scanner.nextDouble();
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public String next() {
        return scanner.next();
    }

    public boolean nextBoolean() {
        return scanner.nextBoolean();
    }
}


