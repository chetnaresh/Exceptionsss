package realtimeexamplesforexceptionhandling;
import java.util.*;


class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}


class InvalidCustomerDataException extends RuntimeException {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}


class Customer {
    int id;
    String name;
    int age;

    public Customer(int id, String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new InvalidCustomerDataException("Customer name cannot be empty.");
        }
        if (age <= 0) {
            throw new InvalidCustomerDataException("Customer age must be positive.");
        }
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer[ID=" + id + ", Name=" + name + ", Age=" + age + "]";
    }
}

public class CustomerManagement {
    private Map<Integer, Customer> customers = new HashMap<>();


    public void addCustomer(Customer customer) {
        customers.put(customer.id, customer);
        System.out.println("Customer added: " + customer);
    }

    public void updateCustomer(int id, String newName, int newAge) throws CustomerNotFoundException {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        if (newName == null || newName.isEmpty()) {
            throw new InvalidCustomerDataException("Updated name cannot be empty.");
        }
        if (newAge <= 0) {
            throw new InvalidCustomerDataException("Updated age must be positive.");
        }

        customer.name = newName;
        customer.age = newAge;
        System.out.println("Customer updated: " + customer);
    }

    public void deleteCustomer(int id) throws CustomerNotFoundException {
        if (!customers.containsKey(id)) {
            throw new CustomerNotFoundException("Cannot delete. Customer with ID " + id + " not found.");
        }
        customers.remove(id);
        System.out.println("Customer with ID " + id + " deleted.");
    }


    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            customers.values().forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        CustomerManagement cms = new CustomerManagement();

        try {

            cms.addCustomer(new Customer(1, "Alice", 28));
            cms.addCustomer(new Customer(2, "Bob", 35));


            cms.displayCustomers();


            cms.updateCustomer(1, "Alice Smith", 29);


            cms.updateCustomer(3, "Charlie", 40);

        } catch (CustomerNotFoundException | InvalidCustomerDataException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        try {

            cms.deleteCustomer(2);

            cms.deleteCustomer(5);

        } catch (CustomerNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }


        cms.displayCustomers();
    }
}
