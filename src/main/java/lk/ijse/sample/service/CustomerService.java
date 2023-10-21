package lk.ijse.sample.service;

import lk.ijse.sample.model.Customer;
import lk.ijse.sample.repository.CustomerRepository;

public class CustomerService {

    CustomerRepository customerRepository= new CustomerRepository();
    public boolean createCustomer(Customer customer) {
        customer.setAge(12);
        return customerRepository.createCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }
}
