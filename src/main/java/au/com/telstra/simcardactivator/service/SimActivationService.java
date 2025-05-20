package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.model.ActuatorRequest;
import au.com.telstra.simcardactivator.model.ActuatorResponse;
import au.com.telstra.simcardactivator.model.SimActivationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimActivationService {
    private final RestTemplate restTemplate;
    private final String actuatorUrl;

    public SimActivationService(RestTemplate restTemplate, @Value("${actuator.url}") String actuatorUrl) {
        this.restTemplate = restTemplate;
        this.actuatorUrl = actuatorUrl;
    }

    public boolean activateSim(SimActivationRequest request) {
        ActuatorRequest actuatorRequest = new ActuatorRequest(request.getIccid());

        try {
            ActuatorResponse response = restTemplate.postForObject(
                    actuatorUrl,
                    actuatorRequest,
                    ActuatorResponse.class
            );

            boolean success = response != null && response.isSuccess();
            System.out.println("SIM activation for ICCID " + request.getIccid() +
                    " and customer email " + request.getCustomerEmail() +
                    " was " + (success ? "successful" : "unsuccessful"));

            return success;
        } catch (Exception e) {
            System.err.println("Error activating SIM: " + e.getMessage());
            return false;
        }
    }

}