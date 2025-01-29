package academy.itk.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramCheckerTest {

    private final AnagramMapBuilder anagramMapBuilder = new AnagramMapBuilder();
    private final AnagramChecker anagramChecker = new AnagramChecker(anagramMapBuilder);

    @Test
    public void check_happy() {
        assertTrue(anagramChecker.check("сосна", "насос"));
    }

    @Test
    public void check_unhappy() {
        assertFalse(anagramChecker.check("парк", "насос"));
    }
}
