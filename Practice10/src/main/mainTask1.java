import java.time.LocalDateTime;
import java.time.ZoneId;

public class mainTask1 {
    public static void main(String[] args) {
        System.out.println("Event Management System");
        Event event1 = new Event("Breakfast: ", LocalDateTime.of(2026, 3,24,8,25), 15, ZoneId.of("Europe/Kyiv"), "Breakfast with coffee" );
        Event event2 = new Event("AbitFest:  ", LocalDateTime.of(2026,3,22,12,30),45, ZoneId.of("Europe/Kyiv"),"Meeting for abiturients");
        Event event3 = new Event("Java Lab: ", LocalDateTime.of(2026, 3, 25, 10, 0), 90, ZoneId.of("Europe/Kyiv"), "Advanced Java");
        Event event4 = new Event("Board Games: ", LocalDateTime.of(2026, 3, 28, 17, 0), 120, ZoneId.of("Europe/Amsterdam"), "Playing Wavelength");

        System.out.println(event1.label());
        System.out.println(event1.end());
        System.out.println(event2.label());
        System.out.println(event2.end());
        System.out.println(event3.label());
        System.out.println(event3.end());
        System.out.println(event4.label());
        System.out.println(event4.end());

    }
}
