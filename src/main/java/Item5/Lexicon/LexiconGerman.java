package Item5.Lexicon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LexiconGerman implements Lexicon{

    public static final Set<String> words = new HashSet<String>(Arrays.asList("Wort","Krass", "Test"));

    public boolean isWord(String word) {
        return words.contains(word);
    }
}
