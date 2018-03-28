package Item5;

import Item5.Lexicon.Lexicon;
import Item5.Lexicon.LexiconEnglish;

import java.util.*;

public class SpellcheckerWithDependencyInjection {

    private final Lexicon lexicon;

    public SpellcheckerWithDependencyInjection(Lexicon lexicon) {
        this.lexicon = Objects.requireNonNull(lexicon);
    }

    public boolean isValid(String word) {
        return lexicon.isWord(word);
    }

    public List<String> suggestions(String typoWord) {
        System.out.println("Some allgorithm to suggest some words");
        return Arrays.asList("test", "testing", "tea");
    }
}
