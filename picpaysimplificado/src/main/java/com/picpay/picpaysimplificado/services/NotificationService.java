package com.picpay.picpaysimplificado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpay.picpaysimplificado.domain.user.User;
import com.picpay.picpaysimplificado.dtos.NotificationDTO;
import com.picpay.picpaysimplificado.infra.exception.NotificationServiceUnavailableException;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        //String email = user.getEmail();
        //NotificationDTO notificationDTO = new NotificationDTO(email, message);

        // ResponseEntity<String> NotificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationDTO, String.class);

        // if(!(NotificationResponse.getStatusCode() == HttpStatus.OK)) {
        //     throw new NotificationServiceUnavailableException("O serviço de notificação está fora do ar");
        // }
    }
}
