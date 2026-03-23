import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



class PaymentGatewayException extends Exception {
    public PaymentGatewayException(String message) {
        super(message);
    }
}

class AppException extends RuntimeException {
    public AppException(String message, Throwable cause) {
        super(message, cause); }
}

class OrderProcessingException extends AppException {
    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause); }
}
class OrderService{
    private static java.util.logging.Logger LoggerFactory;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(OrderService.class);
    public void checkout(Order order){
        try {
            throw new PaymentGatewayException("Connection timeout");
        } catch (PaymentGatewayException e) {
            log.error("Log: Error processing order for {}", order.userEmail());
            throw new OrderProcessingException("Payment failed ", e);
        }
    }
}