package SpringIntroduction.services;

import SpringIntroduction.repository.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository;

    // Dependency Injection thông qua hàm tạo
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Dependency Injection thông qua setter
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}