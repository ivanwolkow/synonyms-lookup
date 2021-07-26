import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

public class SynonymProcessor {

    public void run(BufferedReader reader, Writer writer) throws IOException {
        var testCases = Integer.valueOf(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            var dictionary = new SynonymDictionary();

            var dictionaryLength = Integer.valueOf(reader.readLine());
            for (int j = 0; j < dictionaryLength; j++) {
                String[] words = reader.readLine().split(" ");
                dictionary.add(words[0], words[1]);
            }

            var numberOfQueries = Integer.valueOf(reader.readLine());
            for (int j = 0; j < numberOfQueries; j++) {
                String[] words = reader.readLine().split(" ");

                String result = dictionary.areSynonyms(words[0], words[1]) ? "synonyms\n" : "different\n";
                writer.append(result);
            }
        }
    }
}
