package academy.itk.task4;

public class Producer implements Runnable {

    private final SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            sharedResource.produce();
            Thread.sleep(2000);
            System.out.println("Waited 2 sec");
        } catch (InterruptedException e) {
            System.out.println("The thread was interrupted");
        }
    }
}
