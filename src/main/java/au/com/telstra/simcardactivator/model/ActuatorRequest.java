package au.com.telstra.simcardactivator.model;

// Model for request to actuator service
public class ActuatorRequest {
    private String iccid;

    public ActuatorRequest(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
}