class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccountSystem {

    private double balance;

    public BankAccountSystem(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw an amount
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        // Check if the amount is negative
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        // Check if sufficient balance is available
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        // Perform withdrawal
        balance -= amount;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccountSystem account = new BankAccountSystem(1000.0); // Create an account with initial balance

        try {
            // Attempt to withdraw an amount
            System.out.println("Attempting to withdraw 500...");
            account.withdraw(500.0);
            System.out.println("Withdrawal successful, new balance: " + account.getBalance());

            // Attempt to withdraw an amount greater than the balance
            System.out.println("Attempting to withdraw 600...");
            account.withdraw(600.0); // This will throw InsufficientBalanceException

        } catch (InsufficientBalanceException e) {
            // Handle insufficient balance exception
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            // Handle invalid amount exception
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
