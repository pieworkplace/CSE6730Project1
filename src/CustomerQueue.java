import java.util.ArrayList;
import java.util.List;

public class CustomerQueue extends Heap<Customer>{

    private int customerNum;

    public CustomerQueue() {
        super();
        this.customerNum = heap.size();
    }

    public void addCustomer(Customer customer){
        heappush(customer);
    }

    public Customer removeCustomer(){
        return heappop();
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
