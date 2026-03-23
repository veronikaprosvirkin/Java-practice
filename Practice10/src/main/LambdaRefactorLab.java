import java.util.Comparator;
import java.util.List;

public class LambdaRefactorLab {
    //old method
    public void sortAnonymous(List<Event> events) {
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getStart().compareTo(e2.getStart());
            }
        });
    }

    public void sortLambda(List<Event> events) {
        events.sort((e1, e2) -> e1.getStart().compareTo(e2.getStart()));
    }

    //Method Reference
    public void sortMethodRef(List<Event> events) {
        events.sort(Comparator.comparing(Event::getStart));
    }
}

