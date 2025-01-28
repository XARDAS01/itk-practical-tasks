package academy.itk.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomStringBuilder {

    private final List<CustomStringSnapshot> customStringSnapshots;

    public CustomStringBuilder() {
        this.customStringSnapshots = new ArrayList<>();
    }

    public void append(CustomStringSnapshot customStringSnapshot) {
        this.customStringSnapshots.add(customStringSnapshot);
    }

    public void undo() {
        if (!customStringSnapshots.isEmpty()) {
            customStringSnapshots.remove(customStringSnapshots.size() - 1);
        }
    }

    public CustomStringSnapshot get(int index) {
        return this.customStringSnapshots.get(index);
    }

    @Override
    public String toString() {
        return this.customStringSnapshots.stream()
                .map(CustomStringSnapshot::toString).collect(Collectors.joining());
    }
}
