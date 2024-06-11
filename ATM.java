import java.util.Scanner;

public class ATM {
    private double balance;
    private Scanner scanner;

    public ATM() {
        this.balance = 0.0;
        this.scanner = new Scanner(System.in);
    }

    public void checkBalance() {
        System.out.println("Your balance is: Rs" + balance);
    }

    public void depositMoney() {
        System.out.print("Enter the amount to deposit: Rs");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs" + amount);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    public void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: Rs");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew Rs" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance. Please try again.");
        }
    }

    public void showMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public void start() {
        while (true) {
            showMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}

