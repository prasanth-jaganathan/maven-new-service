package com.mycompany.app;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Background service that simulates monitoring or processing tasks.
 */
public class App {

    private static final String SERVICE_STATUS = "Service is running...";
    private ScheduledExecutorService scheduler;

    // Constructor injection for easier testing
    public App(ScheduledExecutorService scheduler) {
        this.scheduler = scheduler;
    }

    public App() {
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startBackgroundService() {
        // Schedule a task to simulate background work every 10 seconds.
        scheduler.scheduleAtFixedRate(() -> {
            // Simulating background work (could be a health check or task processing).
            System.out.println(SERVICE_STATUS);
            performBackgroundTask();
        }, 0, 10, TimeUnit.SECONDS);
    }

    /**
     * Simulate performing a background task.
     * This could be any functionality like monitoring, database cleanup, or more.
     */
    private static void performBackgroundTask() {
        // Simulate some complex background task, like checking system health or processing data.
        System.out.println("Performing background task... Checking system health.");
    }
}

