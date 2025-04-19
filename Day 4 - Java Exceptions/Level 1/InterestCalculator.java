public class InterestCalculator {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }

        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            double amount = 1000.0;  
            double rate = 5.0;      
            int years = 3;          

            // Calculate interest
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
