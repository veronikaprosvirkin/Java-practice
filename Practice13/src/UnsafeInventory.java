public class UnsafeInventory implements Inventory{
    private int balance;

    public UnsafeInventory (int initialBalance){
        this.balance= initialBalance;
    }

    @Override
    public boolean reserve(int amount) throws InterruptedException {
        if (amount> balance ) {return false;}
        else{
            Thread.sleep(1);
            balance-= amount;
            return true;
        }
    }

    @Override
    public int available() {
        return balance;
    }
}
