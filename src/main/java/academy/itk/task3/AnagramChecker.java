package academy.itk.task3;

public class AnagramChecker {

    private final AnagramMapBuilder anagramMapBuilder;

    public AnagramChecker(AnagramMapBuilder anagramMapBuilder) {
        this.anagramMapBuilder = anagramMapBuilder;
    }

    public boolean check(String s1, String s2) {
        return anagramMapBuilder.build(s1.toCharArray())
                .equals(anagramMapBuilder.build(s2.toCharArray()));
    }
}
