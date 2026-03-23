import java.io.IOException;
import java.io.Writer;

public class ReceiptWriter implements AutoCloseable {
    public void writeReceipt(Order order) throws IOException {
        System.out.println("Receipt for order " + order.id() + " written to file");
        throw new IOException("No space left on device");
    }
    @Override
    public void close() throws Exception {
        System.out.println("ReceiptWriter closed");
    }
}

