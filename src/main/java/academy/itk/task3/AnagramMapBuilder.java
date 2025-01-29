package academy.itk.task3;

import java.util.HashMap;

public class AnagramMapBuilder {

    public HashMap<Character, Integer> build(char[] value) {
        final var result = new HashMap<Character, Integer>();
        for(var el : value) {
            result.put(el, result.getOrDefault(el, 0) + 1);
        }

        return result;
    }
}
