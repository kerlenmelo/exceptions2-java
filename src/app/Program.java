package app;

import java.util.Scanner;

import exceptions.BusinessException;
import model.entities.Account;

public class Program {
    public static Scanner input = new Scanner(System.in);
    
    public static void accountMenu(Account bankAccount) {
        
        while (true) {
            System.out.println("\n\t--- MENU ---\t");
            System.out.print("Choice a option for your account bank: "
                +"\n1 - Deposit" + "\n2 - Withdraw" 
                +"\n3 - End the program" + "\n: ");
            int choice = input.nextInt();
            
            switch (choice) {
                case 1: {
                    System.out.println("\nBank Deposit");
                    System.out.print("Enter the amount of money to deposit: ");
                    Double moneyDeposit = input.nextDouble();
                    bankAccount.deposit(moneyDeposit);
                    System.out.println("Deposit completed successfully. Your balance is now: $" + bankAccount.getBalance());
                    break;
                }
                case 2: {
                    System.out.println("\nBank Withdraw");
                    System.out.print("Enter the amount of money to withdraw: ");
                    Double moneyWithdraw = input.nextDouble();
                    try {
                        bankAccount.withdraw(moneyWithdraw);
                        System.out.println("Withdraw completed successfully. Your balance is now: $"+bankAccount.getBalance());
                    }
                    catch (BusinessException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                default: {
                    return;
                }
                
            }
        }
    }
    public static void main(String[] args) {    
        
        System.out.println("Register bank account");
        System.out.print("Enter account number: ");
        Integer number = input.nextInt();
        input.nextLine();
        System.out.print("Enter the holder name: ");
        String holder = input.nextLine();
        System.out.print("Enter the initial balance: ");
        Double initialBalance = input.nextDouble();
        input.nextLine();
        System.out.print("Enter the withdraw limit: ");
        Double withdrawLimit = input.nextDouble();
        input.nextLine();
        Account bankAccount = new Account(number, holder, initialBalance, withdrawLimit);
        System.out.println("Successfully registered bank account!");
        System.out.println(bankAccount);
        accountMenu(bankAccount);
    }
}
