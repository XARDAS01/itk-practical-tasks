package academy.itk.task1;

public class CustomStringSnapshot {

    private final CustomString state;

    public CustomStringSnapshot(CustomString state) {
        this.state = state;
    }

    public CustomString getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return this.state.toString();
    }
}
