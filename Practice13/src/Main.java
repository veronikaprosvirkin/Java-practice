import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    static List<Order> loadOrders = new ArrayList<>(List.of(
            new Order(1, 1000),
            new Order(2, 2000),
            new Order(3, 3000)
    ));

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=========Task 1==========");
        Runnable sumTask = countSum(loadOrders);
        Runnable maxTask = countMax(loadOrders);
        TaskRunner.runAndWait(List.of(sumTask, maxTask));
        System.out.println("\n=========Task 2==========");
        int unsafeErrors = runStressTest(() -> new UnsafeInventory(100));
        System.out.println("Errors with UnsafeInventory: " + unsafeErrors);

        int safeErrors = runStressTest(() -> new SynchronizedInventory(100));
        System.out.println("Errors with SynchronizedInventory: " + safeErrors);

        System.out.println("\n=========Task 3==========");
        runTest();


    }
    static void runTest() throws InterruptedException {
        Account account1 = new Account(1,2000);
        Account account2 = new Account(2,3000);
        TransferService tr = new TransferService();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i <1000; i++) {
                tr.transfer(account2,account1, 17);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i <1000; i++) {
                tr.transfer(account1,account2, 20);
            }});
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Account 1 final balance: " + account1.getBalance());
        System.out.println("Account 2 final balance: " + account2.getBalance());
        System.out.println("Failed to transfer: " + tr.getFailedTransfers() +" times");
    }


    static int runStressTest(Supplier<Inventory> inventoryFactory) throws InterruptedException {
        int errors = 0;
        for (int i = 0; i < 250; i++) {

            Inventory testInventory = inventoryFactory.get();

            Thread thread1 = new Thread(() -> {
                try { testInventory.reserve(60); }
                catch (InterruptedException e) { throw new RuntimeException(e); }
            });

            Thread thread2 = new Thread(() -> {
                try { testInventory.reserve(60); }
                catch (InterruptedException e) { throw new RuntimeException(e); }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            if (testInventory.available() < 0) {
                errors++;
            }
        }
        return errors;
    }
    static Runnable countSum(List<Order> loadOrders) {
        return () -> {
            int sum = loadOrders.stream().mapToInt(Order::totalCents).sum();
            System.out.println("Total sum: " + sum);
        };
    }
    static Runnable countMax(List<Order> loadOrders) {
        return () -> {
            int max = loadOrders.stream().mapToInt(Order::totalCents).max().orElse(0);
            System.out.println("Max order: " + max);
        };
    }
}
