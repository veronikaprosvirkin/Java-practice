import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaymentLoader {
    public LoadResult load(Path csv) {
        int errors = 0;
        List<Payment> payments = new ArrayList<>();


        try (BufferedReader r = Files.newBufferedReader(csv)) {
            r.readLine();
            String line;
            while ((line = r.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    errors++;
                    continue;
                }
                try {
                    int id = Integer.parseInt(parts[0]);
                    String email = parts[1];
                    PaymentStatus status = PaymentStatus.valueOf(parts[2]);
                    double amountCents = Double.parseDouble(parts[3]);
                    payments.add(new Payment(id, email, status, amountCents));
                } catch (IllegalArgumentException e) {
                    errors++;
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new LoadResult(payments, errors);
    }
}
