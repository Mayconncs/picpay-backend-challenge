package com.picpay.picpaysimplificado.services;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizationService {
    @Autowired
    private RestTemplate restTemplate;

    public Boolean authorizeTransaction() {
        // ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/9b89b419-a2f7-4885-aa86-5ddcea24d520", Map.class);

        // if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
        //     String message = authorizationResponse.getBody().get("message").toString();
        //     return message.equalsIgnoreCase("Autorizado");
        // } else return false;
        return true;
    }
}
