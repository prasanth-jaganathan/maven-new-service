package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.concurrent.ScheduledExecutorService;

import static org.mockito.Mockito.*;

public class AppTest {

    private App app;
    private ScheduledExecutorService schedulerMock;

    @BeforeEach
    public void setup() {
        // Create a mock of ScheduledExecutorService
        schedulerMock = mock(ScheduledExecutorService.class);
        
        // Use the mocked scheduler in the App
        app = new App(schedulerMock);
    }

    @Test
    public void testBackgroundTaskExecution() throws InterruptedException {
        // Call the method that starts the scheduled task
        app.startBackgroundService();

        // Verify that the scheduled task is run at least once
        ArgumentCaptor<Runnable> taskCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(schedulerMock).scheduleAtFixedRate(taskCaptor.capture(), eq(0L), eq(10L), eq(TimeUnit.SECONDS));

        // Capture the Runnable task and execute it
        Runnable capturedTask = taskCaptor.getValue();
        capturedTask.run(); // This simulates the execution of the background task.

        // Verify that the background task was indeed executed
        // You can use logging or actual methods to assert the results.
        // For simplicity, we'll just verify if performBackgroundTask was called:
        // Here, we would check the effect, but for simplicity, we can assume print logs.
        
        // This would normally be done with assertions on log output or state change
        // For example, using a logger with an in-memory appender or a mock to capture output
    }
}

