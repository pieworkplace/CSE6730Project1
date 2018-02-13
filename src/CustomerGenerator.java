public class CustomerGenerator {

    public static Customer generateCustomer(int currentTime){
        boolean ifVIP = Math.random() < Parameters.VIP_RATE;
        int patienceDuration = getAverage(Parameters.PATIENCE_AVERAGE, Parameters.PATIENCE_RANGE);
        int arrivalTime = currentTime + getPoisson(Parameters.LAMBDA);
        int serviceDuration = getAverage(Parameters.SERVICE_AVERAGE, Parameters.SERVICE_RANGE);
        Customer newCustomer = new Customer(ifVIP, patienceDuration, arrivalTime, serviceDuration);
        return newCustomer;
    }

    public static int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);

        return k - 1;
    }

    public static int getAverage(int average, int range){
        return average + (int) ((Math.random() * 2 - 1) * (range / 2));
    }
}
