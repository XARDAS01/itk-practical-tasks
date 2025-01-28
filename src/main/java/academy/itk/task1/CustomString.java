package academy.itk.task1;

public class CustomString {

    private String value;

    public CustomString(String value) {
        this.value = value;
    }

    public CustomStringSnapshot saveSnapshot() {
        return new CustomStringSnapshot(this);
    }

    public void restoreSnapshot(CustomStringSnapshot snapshot) {
        this.value = snapshot.getState().value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
