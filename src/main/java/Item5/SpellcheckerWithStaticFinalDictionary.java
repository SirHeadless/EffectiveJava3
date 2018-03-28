package Item5;

import Item5.Lexicon.LexiconEnglish;

import java.util.Arrays;
import java.util.List;

public class SpellcheckerWithStaticFinalDictionary {

    private static final LexiconEnglish lexicon = new LexiconEnglish();

    private SpellcheckerWithStaticFinalDictionary() {}

    public static boolean isValid(String word) {
        return lexicon.isWord(word);
    }

    public static List<String> suggestions(String typoWord) {
        System.out.println("Some allgorithm to suggest some words");
        return Arrays.asList("test", "testing", "tea");
    }
}
