import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BankAccount account = new BankAccount(
            "ACC-1001",
            "Alex Cruz",
            500.00
        );

        System.out.println("=== BANK ACCOUNT EXCEPTION GATEKEEPER ===");

        System.out.println("Account Created: "
            + account.getAccountNumber());

        System.out.println("Holder: "
            + account.getAccountHolder());

        System.out.printf("Balance: $%.2f%n",
            account.getBalance());

        try {

            // Withdrawal
            System.out.print("\nEnter withdrawal amount: ");
            double withdrawal = input.nextDouble();

            account.withdraw(withdrawal);

            System.out.println("Withdrawal Successful!");

            // Deposit
            System.out.print("\nEnter deposit amount: ");
            double deposit = input.nextDouble();

            account.deposit(deposit);

            System.out.println("Deposit Successful!");

        }

        catch (InsufficientFundsException e) {

            System.out.println("[EXCEPTION CAUGHT]: "
                + e.getMessage());

            System.out.printf("Required: Your withdrawal amount%n");
            System.out.printf("Available: $%.2f%n",
                account.getBalance());

        }

        catch (IllegalArgumentException e) {

            System.out.println("[EXCEPTION CAUGHT]: "
                + e.getMessage());

        }

        catch (java.util.InputMismatchException e) {

            System.out.println("[EXCEPTION CAUGHT]: Invalid input!"
                + " Please enter numeric values.");

        }

        finally {

            System.out.println("\n[SESSION COMPLETE]");

            System.out.printf("Current Balance: $%.2f%n",
                account.getBalance());

            System.out.println("Transaction log updated.");
            System.out.println("Thank you for using our system!");

            input.close();
        }
    }
}


