public class CustomerQueue extends Heap<Customer>{

    /** CustomerQueue represents the queue in the bank.
     * It contains a priority queue of the waiting customers.
     * This class extends Heap and rewrote the compare (priorThan) function.
     * vip customers stands in front of ordinary customers.
     * and the customers then sorted by arrival time.
     */

    private int customerNum;

    public CustomerQueue() {
        super();
        this.customerNum = heap.size();
    }

    public void addCustomer(Customer customer){
        heappush(customer);
        customerNum++;
    }

    public Customer removeCustomer(){
        Customer res = heappop();
        if (res != null){
            customerNum--;
        }
        return res;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    @Override
    boolean priorThan(Customer customer1, Customer customer2) {
        if(customer1.isIfVIP() == customer2.isIfVIP()){
            return customer1.getArrivalTime() < customer2.getArrivalTime();
        }
        else return customer1.isIfVIP();
    }

}
