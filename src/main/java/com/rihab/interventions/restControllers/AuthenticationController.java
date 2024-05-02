package com.rihab.interventions.restControllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.entities.AuthenticationResponse;
import com.rihab.interventions.entities.User;
import com.rihab.interventions.register.LoginRequest;
import com.rihab.interventions.service.AuthenticationService;

@RestController
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
            ) {
        return ResponseEntity.ok(authService.register(request));
    }

 /*
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestParam String login,
            @RequestParam String password
    ) {
        return ResponseEntity.ok(authService.authenticate(login, password));
    }
*/
  
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
             @RequestBody User request
    ) {
    	 return ResponseEntity.ok(authService.authenticate(request));
    }
   
    
    
}