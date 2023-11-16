package model.entities;

import exceptions.BusinessException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
    @Override
    public String toString() {
        return "\nAccount number: " + number 
                + "\nHolder: " + holder 
                + "\nbalance: " + balance 
                + "\nwithdrawLimit: " + withdrawLimit;
    }

    public void deposit (Double amount) {
        this.setBalance(this.getBalance() + amount);
    }
    
    public void withdraw (Double amount) {
        validateWithdraw(amount);
        this.setBalance(this.getBalance() - amount);
    }
    
    private void validateWithdraw (Double amount) {
        if (amount > this.getWithdrawLimit()) {
            throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (this.getBalance() < amount) {
            throw new BusinessException("Withdraw error: not enough balance");
        } 
        
    }
}
