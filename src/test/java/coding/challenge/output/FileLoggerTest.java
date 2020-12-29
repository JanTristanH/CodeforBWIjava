package coding.challenge.output;

import coding.challenge.output.impl.FileLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class FileLoggerTest {

    private FileLogger fileLogger;
    private BufferedReader reader;

    @Before
    public void setUp() {
        fileLogger = new FileLogger("logs", "test.log");
        try {
            reader = new BufferedReader(new FileReader("logs/test.log"));
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void testSingleLineWriting() {
        fileLogger.writeLine("Testline!()10#");
        try {
            assertEquals("Testline!()10#", reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMultiLineWriting() {
        this.fileLogger.writeLine("Testline Test1!");
        this.fileLogger.writeLine("Testline Test2!");
        this.fileLogger.writeLine("Testline Test3!");
        try {
            assertEquals("Testline Test1!", reader.readLine());
            assertEquals("Testline Test2!", reader.readLine());
            assertEquals("Testline Test3!", reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testWriteAfterClosing() {
        this.fileLogger.close();
        this.fileLogger.writeLine("Testline Test!#(10)");
    }

    @After
    public void closeAndDeleteTestData() {
        this.fileLogger.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File filetoDelete = new File("logs/test.log");
        filetoDelete.delete();
        File directoryToDelete = new File("logs");
        directoryToDelete.delete();
    }

}
