import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class ConsoleApplication {

    public static void main(String... args) throws IOException {

        if (args.length < 2) {
            System.out.println("Usage: java -jar app.jar test.in test.out");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        if (Files.notExists(Paths.get(inputFile))) {
            System.out.println("Input file doesn't exist: " + inputFile);
            return;
        }

        Files.write(Paths.get(outputFile), new byte[0], CREATE, TRUNCATE_EXISTING);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             Writer writer = new FileWriter(outputFile)) {

            new SynonymProcessor().run(reader, writer);
        }
    }


}
