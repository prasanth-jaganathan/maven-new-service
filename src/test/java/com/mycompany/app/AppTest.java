package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    // Test the getMessage() method
    @Test
    public void testGetMessage() {
        App app = new App();
        assertEquals("Hello World!", app.getMessage(), "Message should be 'Hello World!'");
    }

    // Test the output of the main method (printed message)
    @Test
    public void testMainMethod() throws InterruptedException {
        // Redirecting the output to capture it
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Start the main method in a separate thread to avoid infinite loop during test
        Thread mainThread = new Thread(() -> App.main(new String[]{}));
        mainThread.start();

        // Wait for some time to let the main method print a few messages
        Thread.sleep(3000); // Sleep for 3 seconds to capture the output

        // Stop the main thread (this is a workaround for the infinite loop)
        mainThread.interrupt();
        mainThread.join();  // Wait for the thread to finish

        // Check that the message "Hello World!" was printed at least once
        String output = outputStream.toString();
        assertTrue(output.contains("Hello World!"), "The output should contain 'Hello World!'");

        // Restore the original System.out
        System.setOut(originalOut);
    }
}
