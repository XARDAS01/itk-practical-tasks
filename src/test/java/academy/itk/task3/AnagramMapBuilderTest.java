package academy.itk.task3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramMapBuilderTest {

    private final AnagramMapBuilder anagramMapBuilder = new AnagramMapBuilder();

    @Test
    public void build_happy() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('h', 1);
        map.put('e', 1);
        map.put('l', 2);
        map.put('o', 1);

        assertEquals(map, anagramMapBuilder.build("hello".toCharArray()));
    }
}
