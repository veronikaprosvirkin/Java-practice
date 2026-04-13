public class SynchronizedInventory implements Inventory {
    private int balance;
    private final Object lock = new Object();

        public SynchronizedInventory(int initialBalance){
            this.balance= initialBalance;
        }

        @Override
        public boolean reserve(int amount) throws InterruptedException {
            synchronized (lock) {
                if (amount > balance) {
                    return false;
                } else {
                    Thread.sleep(1);

                    balance -= amount;
                    return true;
                }
            }
        }

        @Override
        public int available() {
            return balance;
        }
}
