package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {

  AccountDao accountDao;
  CustomerDao customerDao;

  @Autowired
  public CustomerServiceImpl(AccountDao accountDao, CustomerDao customerDao) {
    this.accountDao = accountDao;
    this.customerDao = customerDao;
  }

  @Override
  public Customer registerCustomer(Customer customer) {
    if (customer == null) throw new IllegalArgumentException("Customer data is null");
    if (customer.getAccount() == null) throw new IllegalArgumentException("Account data is null");

    Account createdAccount = accountDao.create(customer.getAccount());
    customer.setAccount(createdAccount);

    Customer createdCustomer = customerDao.create(customer);

    return createdCustomer;
  }

  @Override
  public List<Customer> getAllCustomers() {
   List<Customer> customers = new ArrayList<>(customerDao.findAll());
   customers.sort(Comparator.comparing(Customer::getId));
   customers.sort(Comparator.comparing(Customer::getFirstName));
    return customers;
  }


}
