package se.lexicon.service;

import se.lexicon.model.Customer;

import java.util.List;

public interface CustomerService {

  Customer registerCustomer(Customer customer);

  List<Customer> getAllCustomers();


}
