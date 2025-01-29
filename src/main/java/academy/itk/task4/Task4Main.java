package academy.itk.task4;

import java.util.Random;

public class Task4Main {

    private static final BlockingQueue blockingQueue = new BlockingQueue(2);
    private static final SharedResource sharedResource = new SharedResource();

    public static void main(String[] args) {
        fakeHeavyLoadOnTheServer();

        for (int i = 0; i < 10; i++) {
            final var companyService = new Random().nextInt(2) == 0
                    ? new Producer(sharedResource) : new Consumer(sharedResource);

            blockingQueue.enqueue(new Thread(companyService));
            blockingQueue.size();
        }
    }

    private static void fakeHeavyLoadOnTheServer() {
        final var mainThread = new Thread(() -> {
            while (true) {
                blockingQueue.dequeue();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        mainThread.setDaemon(true);
        mainThread.start();
    }
}
