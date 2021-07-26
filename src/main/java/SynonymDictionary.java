import java.util.*;

public class SynonymDictionary {

    private final Map<String, Set<String>> dictionary = new HashMap<>();

    /**
     * Add two words as synonyms. There may be the following states:
     * - both word1 and word2 are already in the dictionary and are synonyms
     * - both word1 and word2 are already in the dictionary and are not synonyms
     * - both word1 and word2 are not in the dictionary
     * - word1 is in the dictionary while word2 is not
     * - word2 is in the dictionary while word1 is not
     *
     * @param word1
     * @param word2
     */
    public void add(String word1, String word2) {
        var w1 = word1.toLowerCase();
        var w2 = word2.toLowerCase();

        Set<String> w1Synonyms = dictionary.get(w1);
        Set<String> w2Synonyms = dictionary.get(w2);

        //both words are not in dictionary
        if (w1Synonyms == null && w2Synonyms == null) {
            var newSet = new HashSet<String>();
            newSet.add(w1);
            newSet.add(w2);
            dictionary.put(w1, newSet);
            dictionary.put(w2, newSet);
            return;
        }

        //both words are already in dictionary and are synonyms
        if (w1Synonyms == w2Synonyms) {
            return;
        }

        //word1 is not in dictionary
        if (w1Synonyms == null) {
            w2Synonyms.add(w1);
            dictionary.put(w1, w2Synonyms);
            return;
        }
        //word2 is not in dictionary
        if (w2Synonyms == null) {
            w1Synonyms.add(w2);
            dictionary.put(w2, w1Synonyms);
            return;
        }

        //the last possible state - both words are in dictionary but are not synonyms
        w1Synonyms.addAll(w2Synonyms);
        w2Synonyms.forEach(s -> dictionary.put(s, w1Synonyms));
    }

    /**
     * Check whether two words are synonyms
     *
     * @param word1
     * @param word2
     * @return
     */
    public boolean areSynonyms(String word1, String word2) {
        var w1 = word1.toLowerCase();
        var w2 = word2.toLowerCase();

        if (w1.equals(w2)) return true;

        Set<String> synonyms = dictionary.getOrDefault(w1, Collections.emptySet());
        return synonyms.contains(w2);
    }

}
