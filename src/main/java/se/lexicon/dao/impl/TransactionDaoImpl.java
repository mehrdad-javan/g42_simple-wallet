package se.lexicon.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dao.TransactionDao;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
public class TransactionDaoImpl implements TransactionDao {

  Collection<Transaction> storage;

  public TransactionDaoImpl() {
    storage = new ArrayList<>();
  }

  @Override
  public Transaction create(Transaction transaction) {
    if (transaction == null) throw new IllegalArgumentException("transaction is null");
    storage.add(transaction);
    return transaction;
  }

  @Override
  public Optional<Transaction> findById(String id) {
    if (id == null) throw new IllegalArgumentException("id is null");
    return storage.stream().filter(tr -> tr.getTransactionId().equalsIgnoreCase(id)).findFirst();
  }

  @Override
  public Collection<Transaction> findAll() {
    return new ArrayList<>(storage);
  }

  @Override
  public void remove(String id) throws DataNotFoundException {
    Optional<Transaction> result = findById(id);
    if (!result.isPresent()) throw new DataNotFoundException("Transaction not found");
    else storage.remove(result.get());
  }


}
