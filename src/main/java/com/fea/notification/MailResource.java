package com.fea.notification;


import com.fea.notification.model.EmailMessage;
import com.fea.notification.service.SenderMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
public class MailResource {

    private final SenderMailService senderMailService;

    @PostMapping("email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage){
        this.senderMailService.sendMail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("success");
    }
}
