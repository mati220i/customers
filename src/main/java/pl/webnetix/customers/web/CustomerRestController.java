package pl.webnetix.customers.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.webnetix.customers.model.Customer;
import pl.webnetix.customers.service.CustomerService;

import java.util.List;

@Controller
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
    public ResponseEntity getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();

        if(customers != null)
            return new ResponseEntity(customers, HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET)
    public ResponseEntity getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);

        if(customer != null)
            return new ResponseEntity(customer, HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        if(customerService.deleteCustomer(id))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        Customer returnedCustomer = customerService.createCustomer(customer);

        if(returnedCustomer != null)
            return new ResponseEntity(returnedCustomer, HttpStatus.CREATED);
        else
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        Customer returnedCustomer = customerService.updateCustomer(customer);

        if(returnedCustomer != null)
            return new ResponseEntity(returnedCustomer, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
