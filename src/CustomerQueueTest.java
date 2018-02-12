public class CustomerQueueTest {

    public static void test() {
        CustomerQueue customerQueue = new CustomerQueue();
        Customer customer1 = new Customer(true, 1800, 200, 500);
        Customer customer2 = new Customer(false, 1800, 100, 500);
        Customer customer3 = new Customer(true, 1800, 300, 500);
        Customer customer4 = new Customer(false, 1800, 400, 500);
        Customer customer5 = new Customer(false, 1800, 150, 500);
        Customer customer6 = new Customer(true, 1800, 350, 500);
        Customer customer7 = new Customer(true, 1800, 500, 500);

        customerQueue.addCustomer(customer1);
        customerQueue.addCustomer(customer2);
        customerQueue.addCustomer(customer3);
        System.out.println(customerQueue.removeCustomer());
        System.out.println(customerQueue.removeCustomer());
        System.out.println(customerQueue.removeCustomer());
        System.out.println(customerQueue.removeCustomer());
        customerQueue.addCustomer(customer4);
        customerQueue.addCustomer(customer5);
        customerQueue.addCustomer(customer6);
        customerQueue.addCustomer(customer7);

        System.out.println(customerQueue.removeCustomer());
        System.out.println(customerQueue.removeCustomer());
        System.out.println(customerQueue.removeCustomer());
        System.out.println(customerQueue.removeCustomer());
        System.out.println(customerQueue.removeCustomer());
    }
}
