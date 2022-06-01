package se.lexicon.dao.impl;

import se.lexicon.dao.AccountDao;
import se.lexicon.dao.sequencer.AccountIdGenerator;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {

  Collection<Account> storage;

  public AccountDaoImpl() {
    storage = new ArrayList<>();
  }

  @Override
  public void updateBalance(Account account) throws DataNotFoundException {
    if (account == null) throw new IllegalArgumentException("account is null");
    Optional<Account> result = findById(account.getId());
    if (!result.isPresent()) throw new DataNotFoundException("Account not found");
    else storage.forEach(acc -> acc.setBalance(account.getBalance()));
  }

  @Override
  public Account create(Account account) {
    if (account == null) throw new IllegalArgumentException("account is null");
    account.setId(AccountIdGenerator.generateAccountNumber());
    storage.add(account);
    return account;
  }

  @Override
  public Optional<Account> findById(Long id) {
    if (id == null) throw new IllegalArgumentException("id is null");
    return storage.stream().filter(account -> account.getId() == id).findFirst();
  }

  @Override
  public Collection<Account> findAll() {
    return new ArrayList<>(storage);
  }

  @Override
  public void remove(Long id) throws DataNotFoundException {
    Optional<Account> result = findById(id);
    if (!result.isPresent()) throw new DataNotFoundException("Account not found");
    else storage.remove(result.get());
  }


}
