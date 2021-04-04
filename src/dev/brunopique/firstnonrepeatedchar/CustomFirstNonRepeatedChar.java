package dev.brunopique.firstnonrepeatedchar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomFirstNonRepeatedChar {

    private final List<Character> charactersToBeDeleted = new ArrayList<>();
    private final List<Character> listOfCharacters = new ArrayList<>();

    public Character findChar(String sentence) {
        Objects.requireNonNull(sentence, "The sentence cannot be null");
        for (Character c : sentence.toCharArray()) {
            if (!listOfCharacters.contains(c))
                listOfCharacters.add(c);
            else
                charactersToBeDeleted.add(c);
        }

        listOfCharacters.removeAll(charactersToBeDeleted);

        return listOfCharacters.get(0);
    }

}
