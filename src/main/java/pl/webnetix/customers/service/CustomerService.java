package pl.webnetix.customers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.webnetix.customers.model.Customer;
import pl.webnetix.customers.repository.CustomerRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomer(Long id) {
        if(customerRepo.existsById(id)) {
            Customer customer = customerRepo.findById(id).get();
            return customer;
        }
        return null;
    }

    public boolean deleteCustomer(Long id) {
        Customer customer = customerRepo.findById(id).get();

        if(customer != null) {
            customerRepo.delete(customer);
            return true;
        } else
            return false;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        Customer customerFromDB = customerRepo.findById(customer.getCustomerID()).get();
        customerFromDB = customer;
        entityManager.merge(customerFromDB);
        return customerFromDB;
    }

}
