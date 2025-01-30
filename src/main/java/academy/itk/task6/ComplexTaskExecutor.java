package academy.itk.task6;

import java.util.Random;
import java.util.concurrent.*;

public class ComplexTaskExecutor {

    private long result;

    public void executeTasks(int numberOfTasks) {
        final var executorService = Executors.newCachedThreadPool();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1,() -> {
            System.out.println("result count: " + result);
        });

        for(int i = 0; i < numberOfTasks; i++) {
            final var random = new Random();
            final var complexTask = new ComplexTask(
                    random.nextInt(100) + 1,
                    random.nextInt(100) + 1);

            Future<Integer> longValue = executorService.submit(complexTask);
            try {
                cyclicBarrier.await();
                result += longValue.get();
            } catch (InterruptedException | BrokenBarrierException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();
    }
}
