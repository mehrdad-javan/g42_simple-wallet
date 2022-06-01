package se.lexicon.dao.impl;

import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.sequencer.CustomerIdSequencer;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerDaoImpl implements CustomerDao {

  Collection<Customer> storage;

  public CustomerDaoImpl() {
    storage = new ArrayList<>();
  }

  @Override
  public Customer create(Customer customer) {
    if (customer == null) throw new IllegalArgumentException("customer is null");
    customer.setId(CustomerIdSequencer.nextId());
    storage.add(customer);
    return customer;
  }

  @Override
  public Optional<Customer> findById(Long id) {
    if (id == null) throw new IllegalArgumentException("id is null");
    return storage.stream().filter(account -> account.getId() == id).findFirst();
  }

  @Override
  public Collection<Customer> findAll() {
    return new ArrayList<>(storage);
  }

  @Override
  public void remove(Long id) throws DataNotFoundException {
    Optional<Customer> result = findById(id);
    if (!result.isPresent()) throw new DataNotFoundException("Customer not found");
    else storage.remove(result.get());
  }

  @Override
  public List<Customer> findByName(String firstName) {
    if (firstName == null) throw new IllegalArgumentException("firstName is null");
    return storage.stream().filter(customer -> customer.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList());
  }

  @Override
  public List<Customer> findByEmail(String email) {
    if (email == null) throw new IllegalArgumentException("email is null");
    return storage.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
  }
}
