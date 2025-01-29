package academy.itk.task2;

public class FilterService <T> {

    public T[] filter(T[] array, Filter<T> filter) {
        final var result = array.clone();
        for(int i = 0; i < result.length; i++) {
            result[i] = filter.apply(array[i]);
        }

        return result;
    }
}
