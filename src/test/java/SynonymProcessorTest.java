import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

class SynonymProcessorTest {

    private SynonymProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new SynonymProcessor();
    }

    @Test
    void exampleTest() throws IOException, URISyntaxException {

        File tempFile = File.createTempFile("example-", ".out");
        var writer = new FileWriter(tempFile);
        var reader = new BufferedReader(new InputStreamReader(SynonymProcessorTest.class.getClassLoader().getResourceAsStream("in/example.in")));

        processor.run(reader, writer);

        writer.flush();
        writer.close();

        URL resource = SynonymProcessorTest.class.getClassLoader().getResource("out/example.out");
        File expected = new File(resource.toURI());

        Assertions.assertTrue(FileUtils.contentEquals(expected, tempFile));
    }

    @Test
    void exampleBigTest() throws IOException, URISyntaxException {

        File tempFile = File.createTempFile("example_big-", ".out");
        var writer = new FileWriter(tempFile);
        var reader = new BufferedReader(new InputStreamReader(SynonymProcessorTest.class.getClassLoader().getResourceAsStream("in/example_big.in")));

        processor.run(reader, writer);

        writer.flush();
        writer.close();

        URL resource = SynonymProcessorTest.class.getClassLoader().getResource("out/example_big.out");
        File expected = new File(resource.toURI());

        Assertions.assertTrue(FileUtils.contentEquals(expected, tempFile));
    }

    @Test
    void mainTest() throws IOException, URISyntaxException {

        File tempFile = File.createTempFile("test-", ".out");
        var writer = new FileWriter(tempFile);
        var reader = new BufferedReader(new InputStreamReader(SynonymProcessorTest.class.getClassLoader().getResourceAsStream("in/test.in")));

        processor.run(reader, writer);

        writer.flush();
        writer.close();

        URL resource = SynonymProcessorTest.class.getClassLoader().getResource("out/test.out");
        File expected = new File(resource.toURI());

        Assertions.assertTrue(FileUtils.contentEquals(expected, tempFile));
    }


}