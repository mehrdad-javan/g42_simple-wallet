package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.TransactionDao;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;
import se.lexicon.model.Transaction;

import java.util.Optional;

@Component
public class TransactionServiceImpl implements TransactionService {

  CustomerDao customerDao;
  AccountDao accountDao;
  TransactionDao transactionDao;

  @Autowired
  public TransactionServiceImpl(CustomerDao customerDao, AccountDao accountDao, TransactionDao transactionDao) {
    this.customerDao = customerDao;
    this.accountDao = accountDao;
    this.transactionDao = transactionDao;
  }

  @Override
  public Transaction deposit(Long customerId, double amount) throws DataNotFoundException {
    if (customerId == null ) throw new IllegalArgumentException("customer id is not valid");
    if (amount <= 0 ) throw new IllegalArgumentException("amount is not valid");
    Optional<Customer> optionalCustomer = customerDao.findById(customerId);
    if (!optionalCustomer.isPresent()) throw new DataNotFoundException("customer data dose not exist");
    Customer customer = optionalCustomer.get();
    Account account = customer.getAccount();
    account.deposit(amount);
    accountDao.updateBalance(account);

    Transaction transaction= new Transaction(customerId, account.getId(), amount, 1); // type 1 means deposit operation
    Transaction createdTransaction = transactionDao.create(transaction);

    return createdTransaction;
  }

}
