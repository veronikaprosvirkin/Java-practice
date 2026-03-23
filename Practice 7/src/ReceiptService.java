public class ReceiptService{
    public void generate(Order order) {
        try (ReceiptWriter writer = new ReceiptWriter()) {
            writer.writeReceipt(order);
        } catch (Exception e) {
            System.out.println("Error generating receipt for order " + order.id());
        }
    }
}
