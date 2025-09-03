package realtimeexamplesforexceptionhandling;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}


class PoorDrivingRecordException extends Exception {
    public PoorDrivingRecordException(String message) {
        super(message);
    }
}


class HealthIssueException extends Exception {
    public HealthIssueException(String message) {
        super(message);
    }
}


public class PolicyApplication {


    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 70) {
            throw new InvalidAgeException("Invalid Age: Applicant must be between 18 and 70.");
        }
    }


    public static void validateDrivingHistory(int accidents) throws PoorDrivingRecordException {
        if (accidents > 2) {
            throw new PoorDrivingRecordException("Poor Driving Record: Too many accidents.");
        }
    }


    public static void validateHealth(boolean hasSeriousIssue) throws HealthIssueException {
        if (hasSeriousIssue) {
            throw new HealthIssueException("Health Issue: Applicant has serious health conditions.");
        }
    }

    public static void main(String[] args) {
        int age = 75;
        int accidents = 1;
        boolean hasSeriousIssue = false;

        try {
            validateAge(age);
            validateDrivingHistory(accidents);
            validateHealth(hasSeriousIssue);

            System.out.println("Policy Application Approved ");

        } catch (InvalidAgeException | PoorDrivingRecordException | HealthIssueException e) {

            System.out.println("Policy Application Rejected ");
            System.out.println("Reason: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
