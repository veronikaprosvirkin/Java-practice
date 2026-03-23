public class MainOrder {
    private static final Logger logger = LoggerFactory.getLogger(MainOrder.class);
    public static void main(String[] args) {
        try {
            Order correctOrder = new Order(1, "student@univ.edu.ua", 15000L);
            logger.info("Order {} was successfully created", correctOrder.id());
        } catch (IllegalArgumentException e) {
           logger.warn("Validation failed: {}", e.getMessage());
        }

        try {
            Order badOrder = new Order(-5, "blabla@bla", 300l);
        } catch (IllegalArgumentException e) {
        logger.warn("Validation failed: {}", e.getMessage());
    }

        try {
            Order badOrder2 = new Order(5, "blabla@bla", -300l);
        } catch (IllegalArgumentException e) {
            logger.warn("Validation failed: {}", e.getMessage());
        }

        try {
            Order badOrder3 = new Order(-5, "blablabla", -300l);
        } catch (Exception e) {
            logger.error("Everything is incorrect: {}", e.getMessage());
        }
    }
}
