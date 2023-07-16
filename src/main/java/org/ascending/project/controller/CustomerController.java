package org.ascending.project.controller;

import org.ascending.project.model.Customer;
import org.ascending.project.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)

//    public void testCustomers() {
//        logger.info("This is a test...");
//    }

    public List<Customer> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return customers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable(name = "id") Long id){
        logger.info("This is customer controller, get by {}", id);
        return customerService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, params = {"age"})
    public Customer updateCustomerAge(@PathVariable("id") Long id, @RequestParam("age") Integer age){
        logger.info("pass in variable id: {} and age: {}", id.toString(), age);
        Customer c = customerService.getById(id);
        c.setAge(age);
        c = customerService.update(c);
        return c;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Customer customer) {
        logger.info("Post a new object {}", customer.getFirst_name());
    }
}