package au.com.telstra.simcardactivator.model;

// Model for response from actuator service
public class ActuatorResponse {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
