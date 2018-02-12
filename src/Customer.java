public class Customer{

    private boolean ifVIP;
    private int patienceDuration;
    private int arrivalTime;
    private int serviceDuration;

    public Customer(boolean ifVIP, int patienceDuration, int arrivalTime, int serviceDuration) {
        this.ifVIP = ifVIP;
        this.patienceDuration = patienceDuration;
        this.arrivalTime = arrivalTime;
        this.serviceDuration = serviceDuration;
    }

    public boolean isIfVIP() {
        return ifVIP;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ifVIP=" + ifVIP +
                ", patienceDuration=" + patienceDuration +
                ", arrivalTime=" + arrivalTime +
                ", serviceDuration=" + serviceDuration +
                '}';
    }
}
