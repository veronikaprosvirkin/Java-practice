import java.util.concurrent.BlockingQueue;

public class TicketProducer implements Runnable {
    private final int customers;
    private final BlockingQueue<SupportTicket> block;

    public TicketProducer(BlockingQueue<SupportTicket> block, int customers){
    this.block = block;
    this.customers = customers;
    }

    @Override
    public void run() {
        for(int i =0; i < 100; i++){
            try {
                block.put(new SupportTicket(2, "test1", "test1.1"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for(int i = 0; i<customers; i++){
            try {
                block.put(SupportTicket.POISON_PILL);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
