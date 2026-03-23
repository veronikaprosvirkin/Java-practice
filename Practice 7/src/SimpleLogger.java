public class SimpleLogger implements Logger {
    private final String className;

    public SimpleLogger(Class<?> clazz) {
        this.className = clazz.getSimpleName();
    }

    private void log(String level, String message, Object... args) {
        String formatted = message;
        for (Object arg : args) {
            formatted = formatted.replaceFirst("\\{}", String.valueOf(arg));
        }
        System.out.println(String.format("[%s] %s: %s", new java.util.Date(), level, className, formatted));
        }

    @Override
    public void info(String message, Object... args) {
        log("INFO", message, args);
    }

    @Override
    public void error(String message, Object... args) {
        log("ERROR", message, args);
    }

    @Override
    public void warn(String message, Object... args) {
        log("WARN", message, args);
    }
}
