package academy.itk.task5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConcurrentBank {

    private final List<BankAccount> accounts;

    public ConcurrentBank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(BigDecimal balance) {
        final var account = new BankAccount(balance);
        accounts.add(account);

        return account;
    }

    public void transfer(BankAccount target, BankAccount source, BigDecimal amount) {
        if(target.getId().compareTo(source.getId()) < 0) {
            target.lock();
            source.lock();
        } else {
            source.lock();
            target.lock();
        }

        try {
            if (source == target) {
                throw new IllegalArgumentException("Source and target accounts must be different");
            }

            if(accounts.isEmpty()) {
                throw new UnsupportedOperationException("Account list is empty");
            }

            if(!accounts.contains(source) || !accounts.contains(target)) {
                throw new UnsupportedOperationException("Account list does not contain source or target account!");
            }

            final var sourceAccount = accounts.get(accounts.indexOf(source));
            if(sourceAccount.getBalance().compareTo(amount) < 0) {
                throw new UnsupportedOperationException("The requested amount exceeds the available balance in the account!");
            }

            final var targetAccount = accounts.get(accounts.indexOf(target));
            sourceAccount.withdraw(amount);
            targetAccount.deposit(amount);
        } finally {
            target.unlock();
            source.unlock();
        }
    }

    public BigDecimal getTotalBalance() {
        return this.accounts.stream()
                .map(account -> {
                    account.lock();
                    try {
                        return account.getBalance();
                    } finally {
                        account.unlock();
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
