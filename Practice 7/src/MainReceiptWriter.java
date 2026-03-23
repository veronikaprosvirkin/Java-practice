public class MainReceiptWriter {
    public static void main(String[] args) {
        Order order = new Order(3, "veronika@ukma", 10000l );
        ReceiptService receiptService = new ReceiptService();
        receiptService.generate(order);
    }
}
