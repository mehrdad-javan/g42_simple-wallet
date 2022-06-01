package se.lexicon.service;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Transaction;

public interface TransactionService {

  Transaction deposit(Long customerId, double amount) throws DataNotFoundException;
}
