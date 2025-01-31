package academy.itk.task5;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private final UUID id;
    private BigDecimal balance;
    private final ReentrantLock lock;

    public BankAccount(BigDecimal balance) {
        this.id = UUID.randomUUID();
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public UUID getId() {
        return this.id;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
