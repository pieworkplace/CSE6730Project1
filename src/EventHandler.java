public class EventHandler {
    /** EventHandler handles every event including Teller free and Customer arrival.
     */

    public static int handle(EventList eventList, TellerWindows tellerWindows, CustomerQueue customerQueue){
        // Get next event
        Event event = eventList.popEvent();

        // Get current time
        int currentTime = getCurrentTime(event);
        System.out.println("Running Time:" + Timer.numToTime(currentTime));

        // If next event is customer arrival
        if (event instanceof Customer){
            System.out.println(event);

            // add next customer arrival event
            Event newEvent = CustomerGenerator.generateCustomer(currentTime);
            eventList.pushEvent(newEvent);

            // check available teller for the arrived customer
            Teller freeTeller = tellerWindows.checkFreeTeller();
            // if no teller is free, arrived customer -> queue
            if (freeTeller == null){
                customerQueue.addCustomer((Customer) event);
                System.out.println("However, no teller is free. So the customer went to the queue.");
            }
            // if some teller is free, set the customer to some teller
            else {
                int duration = ((Customer) event).getServiceDuration();
                freeTeller.setFreeTime(currentTime + duration);
                freeTeller.addWorkingDuration(duration);
                freeTeller.setFree(false);
                eventList.pushEvent(freeTeller);
                System.out.println("Teller " + freeTeller.getSSN() + " served the customer.");
            }
        }
        // If next event is teller free
        else if (event instanceof Teller){
            System.out.println("Teller " + ((Teller) event).getSSN() + " has just finished work.");

            // Find next customer to serve
            Customer nextCustomer = customerQueue.removeCustomer();
            // If there are customers in the queue
            while (nextCustomer != null){
                Customer.addTotalWaitingTime(currentTime - nextCustomer.getArrivalTime());

                // If the customer in the queue has left due to long wait
                if (nextCustomer.getArrivalTime() + nextCustomer.getPatienceDuration() < currentTime){
                    Customer.setImpatientCustomer(Customer.getImpatientCustomer() + 1);
                    System.out.println("Teller " + ((Teller) event).getSSN() + " called to serve the next customer.");
                    System.out.println("However, the customer had already left due to impatience.");
                    nextCustomer = customerQueue.removeCustomer();
                }
                // Else serve next customer
                else {
                    int duration = nextCustomer.getServiceDuration();
                    System.out.println("Now the teller continue to serve the next customer.");
                    System.out.println(event);
                    ((Teller) event).setFree(false);
                    ((Teller) event).addWorkingDuration(duration);
                    ((Teller) event).setFreeTime(currentTime + duration);
                    eventList.pushEvent(event);
                    return currentTime;
                }
            }
            // If there are no customer in the queue, the teller becomes free
            ((Teller) event).setFree(true);
            System.out.println("No customer is waiting. So the teller is free now.");
            System.out.println(event);
        }
        return currentTime;
    }

    private static int getCurrentTime(Event event){
        if (event instanceof Customer){
            return ((Customer) event).getArrivalTime();
        }
        else {
            return ((Teller) event).getFreeTime();
        }
    }
}
