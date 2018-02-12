import java.util.ArrayList;
import java.util.List;

public class CustomerQueue {

    private int customerNum;
    private List<Customer> queue;

    public CustomerQueue(){
        customerNum = 0;
        queue = new ArrayList<>();
    }

    //TODO
    public void heappush(Customer customer){

    }

    //TODO
    public Customer heappop(){}

    public int getCustomerNum() {
        return customerNum;
    }

}
