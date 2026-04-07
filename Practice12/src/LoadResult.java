import java.util.List;

public record LoadResult(List<Payment> validPayments, int invalidLines) {
}
