package academy.itk.task6;

import java.util.concurrent.Callable;

public class ComplexTask implements Callable<Integer> {

    private final int value1;
    private final int value2;

    public ComplexTask(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public Integer call() throws InterruptedException {
        System.out.println("Computing...");
        Thread.sleep(2000);
        return this.value1 + this.value2;
    }
}
