package academy.itk.task4;

import java.util.LinkedList;

public class BlockingQueue {

    private final int maxThreadQueueSize;
    private final LinkedList<Thread> threadQueue;

    public BlockingQueue(int size) {
        this.maxThreadQueueSize = size;
        this.threadQueue = new LinkedList<>();
    }

    public synchronized void enqueue(Thread thread) {
        while(threadQueue.size() >= maxThreadQueueSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        threadQueue.add(thread);
        System.out.println("Adding thread in queue.");
        thread.start();

        notifyAll();
    }

    public synchronized void dequeue() {
        while(threadQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("delete thread from queue.");
        threadQueue.pop();

        notifyAll();
    }

    public synchronized int size() {
        System.out.printf("Current size is: %s \n", this.threadQueue.size());
        return this.threadQueue.size();
    }

    public synchronized int maxSize() {
        System.out.printf("Max size is: %s \n", this.maxSize());
        return this.maxThreadQueueSize;
    }
}
