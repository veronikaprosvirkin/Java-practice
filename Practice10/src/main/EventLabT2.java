import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EventLabT2 {
    public List<Event> pick(List<Event> events, Predicate<Event> condition){
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (condition.test(event)) {
                result.add(event);
            }
        }
        return result;
    }
    public List<String> labels(List<Event> events, Function<Event, String> formatter){
        List<String> result = new ArrayList<>();
        for (Event event : events) {
            result.add(formatter.apply(event));
        }
        return result;
    }
    public void notifyAll(List<Event> events, Consumer<Event> notifier){
        for (Event event : events){
            notifier.accept(event);
        }
    }
    public Event create(Supplier<Event> generator){
        return generator.get();
    }
    public void findConflicts(List<Event> events){
        for (int i = 0; i < events.size(); i++) {
            Event e1 = events.get(i);
            Instant start1 = e1.getStart().atZone(e1.getZone()).toInstant();
            Instant end1 = e1.end().atZone(e1.getZone()).toInstant();
            for (int j = i + 1; j < events.size(); j++) {
                Event e2 = events.get(j);
                Instant start2 = e2.getStart().atZone(e2.getZone()).toInstant();
                Instant end2 = e2.end().atZone(e2.getZone()).toInstant();
                if (start1.isBefore(end2) && end1.isAfter(start2)) {
                    System.out.println("Conflict found between " + e1.getTitle() + " and " + e2.getTitle());
                }
            }
        }
    }

}
