package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.model.SimActivationRequest;
import au.com.telstra.simcardactivator.service.SimActivationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sim")
public class SimActivationController {
    private final SimActivationService simActivationService;

    public SimActivationController(SimActivationService simActivationService) {
        this.simActivationService = simActivationService;
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activateSim(@RequestBody SimActivationRequest request) {
        boolean success = simActivationService.activateSim(request);

        if (success) {
            return ResponseEntity.ok("SIM activation successful");
        } else {
            return ResponseEntity.ok("SIM activation failed");
        }
    }

}