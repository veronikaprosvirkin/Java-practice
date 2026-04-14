import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class TicketConsumer implements Runnable{
    BlockingQueue<SupportTicket> block;
    ConcurrentHashMap<String, Integer> topicCount;
    public TicketConsumer(BlockingQueue<SupportTicket> block, ConcurrentHashMap<String, Integer> topicCount){
        this.block = block;
        this.topicCount = topicCount;
    }

    @Override
    public void run() {
        while(true){
            try {
                SupportTicket ticket = block.take();
                if(ticket == SupportTicket.POISON_PILL){
                    break;
                }
                topicCount.merge(ticket.topic(), 1, Integer::sum);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
