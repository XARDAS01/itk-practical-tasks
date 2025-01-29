package academy.itk.task4;

public class Consumer implements Runnable {

    private final SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            sharedResource.consume();
            Thread.sleep(2000);
            System.out.println("Waited 2 sec");
        } catch (InterruptedException e) {
            System.out.println("The thread was interrupted");
        }
    }
}
