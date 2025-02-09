package com.mycompany.app;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Background service that simulates monitoring or processing tasks.
 */
public class App {

    private static final String SERVICE_STATUS = "Service is running...";

    public App() {}

    public static void main(String[] args) {
        // Create a ScheduledExecutorService to simulate a periodic task.
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule a task to simulate background work every 10 seconds.
        scheduler.scheduleAtFixedRate(() -> {
            // Simulating background work (could be a health check or task processing).
            System.out.println(SERVICE_STATUS);
            performBackgroundTask();
        }, 0, 10, TimeUnit.SECONDS);
        
        // Keep the service running by preventing the main thread from exiting.
        try {
            Thread.sleep(Long.MAX_VALUE);  // Keeps the service alive indefinitely.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Service was interrupted");
        }
    }

    /**
     * Simulate performing a background task.
     * This could be any functionality like monitoring, database cleanup, or more.
     */
    private static void performBackgroundTask() {
        // Simulate some complex background task, like checking system health or processing data.
        System.out.println("Performing background task... Checking system health.");
        // Here you can add actual logic to interact with databases, files, etc.
        // Example: Simulate checking a database connection, performing cleanup, etc.
    }
}

