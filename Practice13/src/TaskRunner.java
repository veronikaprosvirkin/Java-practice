import java.util.ArrayList;
import java.util.List;

public class TaskRunner {
    public  static void runAndWait(List<Runnable> tasks) {
        List<Thread> threads = new ArrayList<>();
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
