package au.com.telstra.simcardactivator.model;

// Model for incoming requests
public class SimActivationRequest {
    private String iccid;
    private String customerEmail;

    // Getters and setters
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}