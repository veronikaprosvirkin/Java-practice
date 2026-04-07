import java.nio.file.Path;

public class PathSafety {
    public static Path safeResolve(Path base, String userInput) {
        Path resolvedPath = base.resolve(userInput);
        Path normalizedPath = resolvedPath.normalize();
        Path normalizedBase = base.normalize();

        if (!normalizedPath.toAbsolutePath().startsWith(normalizedBase.toAbsolutePath())) {
            throw new IllegalArgumentException("Invalid path: " + userInput);
        }

        return normalizedPath;
    }
}
