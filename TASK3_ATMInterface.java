import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("Deposit of Rs. " + amt + " successful. Current balance: Rs. " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of Rs. " + amount + " successful. Current balance: Rs. " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

class ATM {
    private final BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void initiateTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Current balance: Rs. " + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: Rs. ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: Rs. ");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

public class TASK3_ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account opening amount: Rs. ");
        double initialBal = sc.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBal);

        ATM atm = new ATM(bankAccount);

        boolean exit = false;  // Use a boolean to control the loop

        while (!exit) {
            atm.displayMenu();
            System.out.print("Select an option: ");
            int choice = sc.nextInt();

            if (choice == 4) {
                atm.initiateTransaction(choice, sc);
                exit = true;  // Set exit to true to break the loop
            } else {
                atm.initiateTransaction(choice, sc);
            }
        }

        sc.close();  // Close the Scanner outside the loop
    }
}
