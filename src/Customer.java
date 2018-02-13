public class Customer extends Event{

    private static int numCustomer = 0;
    private static int impatientCustomer = 0;
    private static int totalWaitingTime = 0;
    private boolean ifVIP;
    private int patienceDuration;
    private int arrivalTime;
    private int serviceDuration;

    public Customer(boolean ifVIP, int patienceDuration, int arrivalTime, int serviceDuration) {
        numCustomer++;
        this.ifVIP = ifVIP;
        this.patienceDuration = patienceDuration;
        this.arrivalTime = arrivalTime;
        this.serviceDuration = serviceDuration;
    }

    public static int getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public static void addTotalWaitingTime(int waitingTime) {
        Customer.totalWaitingTime += waitingTime;
    }

    public static int getNumCustomer() {
        return numCustomer;
    }

    public static int getImpatientCustomer() {
        return impatientCustomer;
    }

    public static void setImpatientCustomer(int impatientCustomer) {
        Customer.impatientCustomer = impatientCustomer;
    }

    public boolean isIfVIP() {
        return ifVIP;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceDuration() {
        return serviceDuration;
    }

    public int getPatienceDuration() {
        return patienceDuration;
    }

    @Override
    public String toString() {
        String vip;
        if (ifVIP){
            vip = " A VIP ";
        }
        else{
            vip = "An ordinary ";
        }
        return vip + "customer arrived. The customer requires "
                + Timer.numToTime(serviceDuration) + " service time"
                + " and can only wait for no more than "
                + Timer.numToTime(patienceDuration) + ".";
    }
}
