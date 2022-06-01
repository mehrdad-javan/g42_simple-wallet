package se.lexicon.model;

import java.util.Objects;

public class Customer {

  private long id;
  private String firstName;
  private String lastName;
  private String email;
  private Account account;

  public Customer(String firstName, String lastName, String email, Account account) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.account = account;
  }

  public Customer(long id, String firstName, String lastName, String email, Account account) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.account = account;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return id == customer.id && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(account, customer.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, account);
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", account=" + account +
            '}';
  }
}
