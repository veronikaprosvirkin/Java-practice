public class LoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        return new SimpleLogger(clazz);
    }
}