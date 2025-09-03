package realtimeexamplesforexceptionhandling;
class QuoteGenerationException extends Exception {
    public QuoteGenerationException(String message) {
        super(message);
    }
}


class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

class InsuranceQuoteSystem {


    public double generateQuote(String name, int age, String healthStatus, String vehicleType) throws QuoteGenerationException {


        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Customer name cannot be empty.");
        }
        if (age <= 0) {
            throw new InvalidInputException("Age must be greater than 0.");
        }
        if (healthStatus == null || healthStatus.isEmpty()) {
            throw new InvalidInputException("Health status cannot be empty.");
        }
        if (vehicleType == null || vehicleType.isEmpty()) {
            throw new InvalidInputException("Vehicle type cannot be empty.");
        }

        try {
            double baseQuote = 5000;

            // Factor in age
            if (age < 25) {
                baseQuote += 2000;
            } else if (age > 60) {
                baseQuote += 3000;
            } else {
                baseQuote += 1000;
            }

            if (healthStatus.equalsIgnoreCase("poor")) {
                baseQuote += 4000;
            } else if (healthStatus.equalsIgnoreCase("average")) {
                baseQuote += 2000;
            } else if (healthStatus.equalsIgnoreCase("good")) {
                baseQuote += 1000;
            } else {
                throw new QuoteGenerationException("Invalid health status provided.");
            }

            // Factor in vehicle type
            if (vehicleType.equalsIgnoreCase("car")) {
                baseQuote += 3000;
            } else if (vehicleType.equalsIgnoreCase("bike")) {
                baseQuote += 1500;
            } else {
                throw new QuoteGenerationException("Unsupported vehicle type provided.");
            }

            return baseQuote;

        } catch (Exception e) {
            throw new QuoteGenerationException("Error while generating quote: " + e.getMessage());
        }
    }
}

public class InsuranceQuote {
    public static void main(String[] args) {
        InsuranceQuoteSystem system = new InsuranceQuoteSystem();

        try {
            double quote = system.generateQuote("Alice", 30, "good", "car");
            System.out.println("Generated Quote: ₹" + quote);

            // Example with invalid input
            double quote2 = system.generateQuote("", 22, "poor", "bike");
            System.out.println("Generated Quote: ₹" + quote2);

        } catch (InvalidInputException e) {
            System.err.println("Invalid Input Error: " + e.getMessage());
        } catch (QuoteGenerationException e) {
            System.err.println("Quote Generation Error: " + e.getMessage());
        }
    }
}
