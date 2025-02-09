package com.mycompany.app;

public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        // Infinite loop to print message continuously
        while (true) {
            System.out.println(MESSAGE);
            try {
                // Adding a delay of 1 second between prints to avoid overwhelming output
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Service interrupted");
            }
        }
    }

    public String getMessage() {
        return MESSAGE;
    }
}
