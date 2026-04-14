public record SupportTicket(long id, String customer, String topic) {
    static SupportTicket POISON_PILL = new SupportTicket(-1, "POISON_PILL", "POISON_PILL");
}
