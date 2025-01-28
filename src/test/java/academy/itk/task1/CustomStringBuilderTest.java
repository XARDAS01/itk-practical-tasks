package academy.itk.task1;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomStringBuilderTest {

    @ParameterizedTest
    @InstancioSource
    public void customStringBuilder_append_happy(
            CustomString first, CustomString second, CustomString third) {
        final var customStringBuilder = new CustomStringBuilder();
        customStringBuilder.append(first.saveSnapshot());
        customStringBuilder.append(second.saveSnapshot());
        customStringBuilder.append(third.saveSnapshot());

        final var stringBuilder = new StringBuilder();
        stringBuilder.append(first);
        stringBuilder.append(second);
        stringBuilder.append(third);

        assertEquals(stringBuilder.toString(), customStringBuilder.toString());
    }

    @ParameterizedTest
    @InstancioSource
    public void customStringBuilder_undo_happy(
            CustomString first, CustomString second, CustomString third) {
        final var customStringBuilder = new CustomStringBuilder();
        customStringBuilder.append(first.saveSnapshot());
        customStringBuilder.append(second.saveSnapshot());
        customStringBuilder.append(third.saveSnapshot());
        customStringBuilder.undo();

        final var stringBuilder = new StringBuilder();
        stringBuilder.append(first);
        stringBuilder.append(second);

        assertEquals(stringBuilder.toString(), customStringBuilder.toString());
    }

    @ParameterizedTest
    @InstancioSource
    public void customStringBuilder_restore_happy(
            CustomString first, CustomString second, CustomString third, CustomStringSnapshot customStringSnapshot) {
        final var customStringBuilder = new CustomStringBuilder();
        customStringBuilder.append(first.saveSnapshot());
        customStringBuilder.append(second.saveSnapshot());
        customStringBuilder.append(third.saveSnapshot());
        customStringBuilder.get(0).getState().restoreSnapshot(customStringSnapshot);

        final var stringBuilder = new StringBuilder();
        stringBuilder.append(customStringSnapshot);
        stringBuilder.append(second);
        stringBuilder.append(third);

        assertEquals(stringBuilder.toString(), customStringBuilder.toString());
    }
}
