package task2;

import java.util.Scanner;

public class BankingApplication {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Account a = new Account("rama", "10");
	        a.menu();
	    }
	}

	class Account {
	    float balance;
	    float remainingAmount;
	    String customerName;
	    String customerId;

	    Account(String cname, String cid) {
	        customerName = cname;
	        customerId = cid;
	    }

	    void deposit(float amount) {
	        if (amount != 0) {
	            balance = balance + amount;
	            remainingAmount = amount;
	        }
	    }

	    void withdraw(float amount) {
	        if (amount != 0 && balance >= amount) {
	            balance = balance - amount;
	            remainingAmount = -amount;
	        } else if (amount > balance) {
	            System.out.println("Insufficient balance.");
	        }
	    }

	    void checkBalance() {
	        if (remainingAmount > 0) {
	            System.out.println("Deposited: " + remainingAmount);
	        } else if (remainingAmount < 0) {
	            System.out.println("Withdrawn: " + Math.abs(remainingAmount));
	        } else {
	            System.out.println("No transaction happened yet!!");
	        }
	    }

	    void menu() {
	        char option = '\0';
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Welcome " + customerName);
	        System.out.println("Your ID is: " + customerId);
	        System.out.println();
	        System.out.println("A : Check Balance");
	        System.out.println("B : Deposit");
	        System.out.println("C : Withdraw");
	        System.out.println("D : Exit");

	        do {
	            System.out.println("*");
	            System.out.println("Enter the option:");
	            System.out.println("====================");
	            option = sc.next().charAt(0);
	            option = Character.toUpperCase(option);

	            switch (option) {
	                case 'A':
	                    System.out.println("*");
	                    System.out.println("Balance is: " + balance);
	                    System.out.println("*");
	                    checkBalance();
	                    System.out.println();
	                    break;

	                case 'B':
	                    System.out.println("*");
	                    System.out.println("Enter amount to deposit:");
	                    float amount = sc.nextFloat();
	                    deposit(amount);
	                    System.out.println();
	                    break;

	                case 'C':
	                    System.out.println("*");
	                    System.out.println("Enter amount to withdraw:");
	                    float amount2 = sc.nextFloat();
	                    withdraw(amount2);
	                    System.out.println();
	                    break;

	                case 'D':
	                    System.out.println("*");
	                    System.out.println("Exiting the application.");
	                    break;

	                default:
	                    System.out.println("Invalid option! Please try again.");
	                    break;
	            }
	        } while (option != 'D');
	    }
	}
