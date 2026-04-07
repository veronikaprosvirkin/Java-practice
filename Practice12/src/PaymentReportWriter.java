import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PaymentReportWriter {
    public static void writeReport(Path out, List<Payment> payments, int invalidLines) throws IOException {
        long paidTotalCents = 0;
        int newCount = 0;
        int paidCount = 0;
        int failedCount = 0;
        for (Payment payment : payments) {
            if (payment.status() == PaymentStatus.PAID) {
                paidTotalCents += payment.amountCents();
                paidCount++;
            } else if (payment.status() == PaymentStatus.NEW) {
                newCount++;
            } else if (payment.status() == PaymentStatus.FAILED) {
                failedCount++;
            }
        }
            Path tempFile = out.resolveSibling(out.getFileName() + "tmp");
            try (BufferedWriter w = Files.newBufferedWriter(tempFile)) {
                w.write("invalidLines = " + invalidLines);
                w.newLine();
                w.write("paidTotalCents = " + paidTotalCents);
                w.newLine();
                w.write(String.format("NEW = %d, PAID = %d, FAILED = %d", newCount, paidCount, failedCount));
                w.newLine();
            }
        Files.move(tempFile, out,
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.ATOMIC_MOVE);
    }
}
