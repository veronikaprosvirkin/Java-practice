import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

sealed interface Result permits Success, Failure {
}

record Success(String positive) implements Result {}


record Failure(String negative) implements Result {}

public class ResultTask {
    public static void main(String[] args) {


        List<Result> results = List.of(
                new Success("Success"),
                new Failure("Failure"),
                new Success("Login successful"),
                new Failure("Login failed")
        );

        Map<Boolean, Long> count = results.stream().collect(Collectors.
                groupingBy(result -> result instanceof Success, Collectors.counting()));
        System.out.println("Number of Success: " + count.get(true));
        System.out.println("Number of Failure: " + count.get(false));

        List<String> errorMessage = results.stream().filter(result -> result instanceof Failure)
                .map(result -> (Failure) result).map(Failure::negative).toList();
        System.out.println("\nError messages: " + errorMessage);
    }
}
