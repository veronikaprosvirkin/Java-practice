import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
        public static void main(String[] args) {
            List<Book> books = List.of(
                    new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
                    new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
                    new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
                    new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java")));


            List<Sale> sales = List.of(
                    new Sale("a@ex.com", "Tea", 120),
                    new Sale("b@ex.com", "Cake", 200),
                    new Sale("a@ex.com", "Tea", 120),
                    new Sale("c@ex.com", "Coffee", 150),
                    new Sale("b@ex.com", "Cake", 200)
            );

            List<String> result = books.stream().filter(book -> book.year()> 2015)
                    .map(book -> book.title().toUpperCase())
                    .sorted().limit(3).toList();

            System.out.println(result);

            List<String> uniqueTags = books.stream().flatMap(book -> book.tags().stream())
                    .distinct().sorted().toList();

            System.out.println(uniqueTags);

            Map<String, Long> sorted = books.stream().flatMap(book -> book.tags().stream())
                    .collect(Collectors.groupingBy(tag-> tag, Collectors.counting()));

            int n = 2;
            sorted.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .limit(n)
                    .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


            Map<String, Integer> task3 = sales.stream().collect(Collectors.toMap(Sale::product, Sale::cents, Integer::sum));
            System.out.println("\nSum of sales by product: ");
            task3.forEach((product, total) -> System.out.println(product + " : " + total));

            Map<String, Long> transactionsByCustomer = sales.stream()
                    .collect(Collectors.groupingBy(Sale::customerEmail, Collectors.counting()
                    ));

            System.out.println("\nNumber of transactions by customer: ");
            transactionsByCustomer.forEach((email, count) -> System.out.println(email + " : " + count));

            System.out.println("=======TASK 5=======");
            Map<Boolean, List<Book>> recentVsOld = books.stream().collect(Collectors.partitioningBy(book -> book.year() > 2015));
            System.out.println("\nNew books");
            recentVsOld.get(true).forEach(book -> System.out.println(book.title()));
            System.out.println("\nOld books");
            recentVsOld.get(false).forEach(book -> System.out.println(book.title()));
            System.out.println("\n");

            Map<String, Integer> revenueSort = sales.stream()
                    .collect(Collectors.toMap(
                            Sale::product,
                            Sale::cents,
                            Integer::sum,
                            TreeMap::new
                    ));
            System.out.println("\nRevenue by product:");
            revenueSort.forEach((product, revenue) ->
                    System.out.println(product + " : " + revenue));
        }

}
