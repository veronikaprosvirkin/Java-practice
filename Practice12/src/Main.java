import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TASKS 1 & 2 ---");
        Path filepath = Path.of("Practice12/payments.csv");
        Path output = Path.of("Practice12/report.txt");

        try {
            PaymentLoader loader = new PaymentLoader();
            LoadResult result = loader.load(filepath);

            System.out.println("Number of valid payments: " + result.validPayments().size());
            System.out.println("Number of invalid lines: " + result.invalidLines());

            PaymentReportWriter.writeReport(output, result.validPayments(), result.invalidLines());
            System.out.println("Report successfully saved to file: " + output);
        } catch (Exception e) {
            System.out.println("Error (Tasks 1-2): " + e.getMessage());
        }
        System.out.println();


        System.out.println("--- TASK 3: File Archiving with NIO.2 ---");
        Path inbox = Path.of("Practice12/practical-data/inbox");
        Path archive = Path.of("Practice12/practical-data/archive");

        try {
            InboxArchiver.archiveTmpFiles(inbox, archive);
            System.out.println("All .tmp files successfully moved to: " + archive);
        } catch (Exception e) {
            System.out.println("Error (Task 3): " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- TASK 4: Safe Paths (PathSafety) ---");
        Path basePath = Path.of("practical-data");

        try {
            System.out.print("[Case 1 - Normal path]: ");
            Path safeResult = PathSafety.safeResolve(basePath, "reports/2025.txt");
            System.out.println("Allowed -> " + safeResult);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        try {
            System.out.print("[Case 2 - Hack attempt]: ");
            Path unsafeResult = PathSafety.safeResolve(basePath, "../secret.txt");
            System.out.println("Allowed -> " + unsafeResult);
        } catch (Exception e) {
            System.out.println("Blocked! " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- TASK 5: Specific Byte Update ---");
        Path filePath = Path.of("status.bin");
        int N = 10;

        try {
            byte[] emptyData = new byte[N];
            Files.write(filePath, emptyData);
            System.out.println("File " + filePath + " created (" + N + " zero bytes).");

            byte newStatus = 7;
            StatusFile.updateStatus(filePath, 4, newStatus);

        } catch (IOException e) {
            System.out.println("Error (Task 5): " + e.getMessage());
        }
        System.out.println("\n==================================================");
        System.out.println("                ALL TASKS COMPLETED               ");
        System.out.println("==================================================");
    }
}
