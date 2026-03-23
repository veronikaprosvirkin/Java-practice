import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeLab {
    public Instant toInstant(Event e) {
        return e.getStart().atZone(e.getZone()).toInstant();
    }

    //differences in minutes
    public long minutesBetween(Event a, Event b) {

        Instant instantA = toInstant(a);
        Instant instantB = toInstant(b);

        return Math.abs(Duration.between(instantA, instantB).toMinutes());
    }

    // different time zone
    public ZonedDateTime startInZone(Event e, String zone) {
        return e.getStart()
                .atZone(e.getZone())
                .withZoneSameInstant(ZoneId.of(zone));
    }
}
