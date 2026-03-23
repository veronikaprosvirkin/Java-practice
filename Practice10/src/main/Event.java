
import java.time.LocalDateTime;
import java.time.ZoneId;


public class Event {
    private String title;
    private LocalDateTime start;
    private int durationMinutes;
    private ZoneId zone;
    private String track;

    public Event(String title, LocalDateTime start, int durationMinutes, ZoneId zone, String track) {
        this.title = title;
        this.start = start;
        this.durationMinutes = durationMinutes;
        this.zone = zone;
        this.track = track;
    }

    public String label(){
        return title+track;
    }
    public LocalDateTime end(){
        return start.plusMinutes(durationMinutes);
    }
    public LocalDateTime getStart(){ return start;}

    public int getDurationMinutes(){ return durationMinutes;}

    public String getTitle() { return title;
    }
    public ZoneId getZone() { return zone; }
}
