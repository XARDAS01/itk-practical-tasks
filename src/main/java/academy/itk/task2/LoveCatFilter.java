package academy.itk.task2;

public class LoveCatFilter implements Filter<String> {

    @Override
    public String apply(String o) {
        return  o.trim() + " Love Cat!";
    }
}
