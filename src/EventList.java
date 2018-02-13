public class EventList extends Heap<Event>{

    /** This class is the priority queue of event.
     * It rewrote the compare method priorThan.
     * Elements in the queue are events.
     * They are sorted by arrival time or teller free time.
     */

    public Event popEvent(){
        return heappop();
    }

    public void pushEvent(Event event){
        heappush(event);
    }

    @Override
    boolean priorThan(Event item1, Event item2) {
        int timeStamp1, timeStamp2;
        if (item1 instanceof Customer){
            timeStamp1 = ((Customer) item1).getArrivalTime();
        }
        else {
            timeStamp1 = ((Teller) item1).getFreeTime();
        }
        if (item2 instanceof Customer){
            timeStamp2 = ((Customer) item2).getArrivalTime();
        }
        else {
            timeStamp2 = ((Teller) item2).getFreeTime();
        }
        return timeStamp1 < timeStamp2;
    }
}
