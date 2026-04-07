import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class InboxArchiver {
    public static void archiveTmpFiles(Path inbox, Path archive) throws IOException {
        if (!Files.exists(archive)) {
            Files.createDirectories(archive);
        }
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(inbox, "*.tmp")) {
            for (Path file : stream) {
                Path target = archive.resolve(file.getFileName());
                Files.move(file, target);
            }
        }
    }
}
