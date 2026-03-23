import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class mainTask2 {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        events.add(new Event("Breakfast ", LocalDateTime.of(2026, 3,24,8,25), 15, ZoneId.of("Europe/Kyiv"), "Breakfast with coffee" ));
        events.add(new Event("Java Lab ", LocalDateTime.of(2026, 3, 25, 10, 0), 90, ZoneId.of("Europe/Kyiv"), "Advanced Java"));
        events.add(new Event("Board Games ", LocalDateTime.of(2026, 3, 28, 17, 0), 120, ZoneId.of("Europe/Amsterdam"), "Playing Wavelength"));
        events.add(new Event("Morning Call ", LocalDateTime.of(2026, 3, 24, 8, 30), 20, ZoneId.of("Europe/Kyiv"), "Urgent call"));

        EventLabT2 eventLab = new EventLabT2();

        Predicate<Event> isMorning = event -> event.getStart().getHour() < 12;
        Predicate<Event> isLong = event -> event.getDurationMinutes() > 60;
        Predicate<Event> needCoffee = isMorning.and(isLong);

        //test pick
        System.out.println("===Pick===");
        List<Event> morningEvents = eventLab.pick(events, needCoffee);
        for (Event e : morningEvents){
            System.out.println(e.label());
        }

        //test labels
        System.out.println("===Labels===\n");
        List<String> upperLabels = eventLab.labels(events, event -> event.getTitle().toUpperCase());
        for (String s : upperLabels) {
            System.out.println(s);
        }
        //test notifyAll
        System.out.println("===Notifier===\n");
        eventLab.notifyAll(events, event -> System.out.println("Coming soon "+ event.getTitle()));
        //test create
        System.out.println("===Create===\n");
        Event newEvent = eventLab.create(() -> new Event("Emergency: ", LocalDateTime.now(), 30, ZoneId.of("Europe/Kyiv"), "Urgent"));
        System.out.println("Created event: " + newEvent.label());

        System.out.println("===Conflicts===\n");
        eventLab.findConflicts(events);
    }
}
