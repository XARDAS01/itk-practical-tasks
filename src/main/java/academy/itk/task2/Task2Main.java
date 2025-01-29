package academy.itk.task2;

import java.util.Arrays;

public class Task2Main {

    private static final String[] names = new String[]{
            "Петр",
            "Вадим",
            "Илья     "
    };

    public static void main(String[] args) {
        final var service = new FilterService<String>();
        final var namesWithFilterApply = service.filter(names, new LoveCatFilter());
        System.out.println(Arrays.toString(namesWithFilterApply));
    }
}
