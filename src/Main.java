import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        CustomerQueueTest.test();

        //TODO impatient customer leave

        int currentTime = 0;
        TellerWindows tellerWindows = new TellerWindows(Parameters.WINDOW_NUM);
        CustomerQueue customerQueue = new CustomerQueue();
        EventList eventList = new EventList();

        // First customer came
        Customer firstCustomer = CustomerGenerator.generateCustomer(currentTime);
        eventList.pushEvent(firstCustomer);
        System.out.println("====================");
        while (currentTime <= Parameters.RUNTIME){
            currentTime = EventHandler.handle(eventList, tellerWindows, customerQueue);
            System.out.println(Integer.toString(customerQueue.getCustomerNum()) + " customer(s) are waiting in the queue.");
            System.out.println(Integer.toString(tellerWindows.checkFreeTellerNum()) + " teller(s) are free.");
            System.out.println("====================");
        }
        System.out.println("********** Statistics **********");
        System.out.println("The bank opened for " + Timer.numToTime(Parameters.RUNTIME) + ".");
        System.out.println("The bank opened " + Integer.toString(Parameters.WINDOW_NUM) + " windows.");
        System.out.println("On average, every teller worked for " + Timer.numToTime(tellerWindows.averageServiceTime()) + ".");
        System.out.println("That is, every teller was working " + Integer.toString(100 * tellerWindows.averageServiceTime() / Parameters.RUNTIME) + "% of their working time.");
        System.out.println("In the bank open time, " + Integer.toString(Customer.getNumCustomer()) + " customer arrived.");
        System.out.println(Integer.toString((int) (Parameters.VIP_RATE * 100)) + "% of customers are VIPs.");
        System.out.println(Integer.toString(Customer.getImpatientCustomer()) + " left due to long waiting.");
        System.out.println("On average, every customer have to wait for " + Timer.numToTime(Customer.getTotalWaitingTime() / Customer.getNumCustomer()) + ".");
        return;
    }
}
