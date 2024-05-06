package org.image;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class NamesGenerator {
    // Enhanced to accept a character array for the alphabet and the maximum length of a name
    public List<String> generateNames(char[] alphabet, int maxLength, int totalNames) {
        List<String> names = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < totalNames; i++) {
            StringBuilder name = new StringBuilder();
            for (int j = 0; j < maxLength; j++) {
                name.append(alphabet[random.nextInt(alphabet.length)]);
            }
            names.add(name.toString());
        }
        return names;
    }
}
