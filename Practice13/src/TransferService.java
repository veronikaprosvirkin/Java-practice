import lombok.Getter;
@Getter
public class TransferService {

    int failedTransfers = 0;
    public void transfer(Account to, Account from, double amount) {

        if (to.getId() == from.getId()) {
            System.out.println("The same account: " + to.getId());
            return;
        }
        Account firstLock;
        Account secondLock;
        if (to.getId() < from.getId()) {
            firstLock = to;
            secondLock = from;
        } else {
            firstLock = from;
            secondLock = to;
        }
        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.getBalance() >= amount) {
                    from.setBalance(from.getBalance() - amount);
                    to.setBalance(to.getBalance() + amount);
                } else {
                    failedTransfers++;
                }
            }
        }
    }

}
