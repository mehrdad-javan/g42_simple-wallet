package se.lexicon.model;

import se.lexicon.exception.InsufficientFoundsException;

import java.util.Objects;

public class Account {

  private long id;
  private double balance;

  public Account() {
  }

  public Account(double balance) {
    this.balance = balance;
  }

  public Account(long id, double balance) {
    this.id = id;
    this.balance = balance;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount){
    if (amount <= 0 ) throw new IllegalArgumentException("amount is not valid");
    this.balance += amount;
  }

  public void withdraw(double amount) throws InsufficientFoundsException{
    if (amount <= 0 ) throw new IllegalArgumentException("amount is not valid");
    if (amount > this.balance) throw new InsufficientFoundsException("amount is insufficient");
    this.balance -= amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return id == account.id && Double.compare(account.balance, balance) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, balance);
  }

  @Override
  public String toString() {
    return "Account{" +
            "id=" + id +
            ", balance=" + balance +
            '}';
  }
}
