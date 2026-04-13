public interface Inventory {
    boolean reserve(int amount) throws InterruptedException;
    int available();
}
