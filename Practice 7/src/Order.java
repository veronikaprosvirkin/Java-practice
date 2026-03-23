public record Order(int id, String userEmail, Long totalCents) {
    public Order{
        if (id<0)
            throw new IllegalArgumentException("id must be positive");
        if (userEmail == null || !userEmail.contains("@"))
            throw new IllegalArgumentException("userEmail must be non-null and contain @");
        if (totalCents < 0)
            throw new IllegalArgumentException("totalCents must be non-negative");
    }

}
