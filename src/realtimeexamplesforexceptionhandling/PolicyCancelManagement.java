package realtimeexamplesforexceptionhandling;
class CancellationNotAllowedException extends Exception {
    public CancellationNotAllowedException(String message) {
        super(message);
    }
}

class PolicyNotFoundException extends Exception {
    public PolicyNotFoundException(String message) {
        super(message);
    }
}


class Policy {
    String policyId;
    String status;
    boolean cancellable;

    public Policy(String policyId, boolean cancellable) {
        this.policyId = policyId;
        this.cancellable = cancellable;
        this.status = "Active";
    }

    @Override
    public String toString() {
        return "Policy ID: " + policyId + ", Status: " + status;
    }
}


class PolicyCancellation {

    public void cancelPolicy(Policy policy, String policyId)
            throws PolicyNotFoundException, CancellationNotAllowedException {

        if (policy == null || !policy.policyId.equals(policyId)) {
            throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
        }

        if (!policy.cancellable) {
            throw new CancellationNotAllowedException(
                    "Policy with ID " + policyId + " cannot be cancelled as per terms and conditions."
            );
        }


        policy.status = "Cancelled";
        System.out.println("Policy " + policyId + " has been successfully cancelled.");
    }
}

public class PolicyCancelManagement {
    public static void main(String[] args) {
        PolicyCancellation cancellationSystem = new PolicyCancellation();


        Policy p1 = new Policy("POL123", true);
        Policy p2 = new Policy("POL456", false);

        try {

            cancellationSystem.cancelPolicy(p1, "POL123");
            System.out.println(p1);


            cancellationSystem.cancelPolicy(p2, "POL456");
            System.out.println(p2);

        } catch (PolicyNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (CancellationNotAllowedException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            cancellationSystem.cancelPolicy(null, "POL789");
        } catch (PolicyNotFoundException | CancellationNotAllowedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
