package se.lexicon.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

  private String transactionId;
  private long customerId;
  private long accountId;
  private double amount;
  private int type; // 1: deposit, 0: withdraw
  private LocalDateTime dateTime;

  public Transaction(long customerId, long accountId, double amount, int type) {
    this.transactionId = UUID.randomUUID().toString();
    this.customerId = customerId;
    this.accountId = accountId;
    this.amount = amount;
    this.type = type;
    this.dateTime = LocalDateTime.now();
  }

  public String getTransactionId() {
    return transactionId;
  }

  public long getCustomerId() {
    return customerId;
  }

  public long getAccountId() {
    return accountId;
  }

  public double getAmount() {
    return amount;
  }

  public int getType() {
    return type;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  @Override
  public String toString() {
    return "Transaction{" +
            "transactionId='" + transactionId + '\'' +
            ", customerId=" + customerId +
            ", accountId=" + accountId +
            ", amount=" + amount +
            ", type=" + type +
            ", dateTime=" + dateTime +
            '}';
  }
}
