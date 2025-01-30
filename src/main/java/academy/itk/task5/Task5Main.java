package academy.itk.task5;

import java.math.BigDecimal;

public class Task5Main {

    public static void main(String[] args) {
        final var concurrentBank = new ConcurrentBank();

        final var account1 = concurrentBank.createAccount(BigDecimal.valueOf(1000));
        final var account2 = concurrentBank.createAccount(BigDecimal.valueOf(500));

        Thread transferThread1 = new Thread(() ->
                concurrentBank.transfer(account1, account2, BigDecimal.valueOf(200)));
        Thread transferThread2 = new Thread(() ->
                concurrentBank.transfer(account2, account1, BigDecimal.valueOf(100)));
        Thread transferThread3 = new Thread(() ->
                account1.deposit(BigDecimal.valueOf(400)));

        transferThread1.start();
        transferThread2.start();
        transferThread3.start();

        try {
            transferThread1.join();
            transferThread2.join();
            transferThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance: " + concurrentBank.getTotalBalance());
    }
}
