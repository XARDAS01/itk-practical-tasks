package academy.itk.task2;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoveCatFilterTest {

    private final LoveCatFilter loveCatFilter = new LoveCatFilter();

    @ParameterizedTest
    @InstancioSource
    public void sdf_happy(String name) {
        assertEquals(name + " Love Cat!", loveCatFilter.apply(name));
    }
}
