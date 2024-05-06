package org.image;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NamesGeneratorTest {
    @Test
    void testGenerateNamesWithValidAlphabet() {
        NamesGenerator generator = new NamesGenerator();
        // Define the alphabet and maximum length of a name
        char[] alphabet = {'A', 'B', 'C'};
        int maxLength = 2;
        int totalNames = 10;  // Let's generate 10 names
        List<String> names = generator.generateNames(alphabet, maxLength, totalNames);

        assertFalse(names.isEmpty(), "The list of names should not be empty");
        assertTrue(names.stream().allMatch(name -> name.length() <= maxLength),
                "All names should be of valid length");
        assertTrue(names.stream().noneMatch(name -> name.contains("AAA") || name.contains("BBB") || name.contains("CCC")),
                "Names should not contain invalid sequences");
    }
}
