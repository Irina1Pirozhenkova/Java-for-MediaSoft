package model;

import java.time.LocalDateTime;

public class BankAccount {
  private String ownerName;
  private int balance;
  private LocalDateTime openedAt;
  private boolean isBlocked;

  public BankAccount(String ownerName) {
    this.ownerName = ownerName;
    this.balance = 0;
    this.openedAt = LocalDateTime.now();
    this.isBlocked = false;
  }

  public boolean deposit(int amount) {
    if (isBlocked || amount <= 0) {
      return false;
    }
    balance += amount;
    return true;
  }

  public boolean withdraw(int amount) {
    if (isBlocked || amount <= 0 || amount > balance) {
      return false;
    }
    balance -= amount;
    return true;
  }

  public boolean transfer(BankAccount otherAccount, int amount) {
    if (otherAccount == null || isBlocked || otherAccount.isBlocked || amount <= 0 || amount > balance) {
      return false;
    }
    balance -= amount;
    boolean credited = otherAccount.deposit(amount);
    if (!credited) {
      balance += amount;
      return false;
    }
    return true;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public int getBalance() {
    return balance;
  }

  public LocalDateTime getOpenedAt() {
    return openedAt;
  }

  public boolean isBlocked() {
    return isBlocked;
  }

  public void block() {
    isBlocked = true;
  }

  public void unblock() {
    isBlocked = false;
  }
}
