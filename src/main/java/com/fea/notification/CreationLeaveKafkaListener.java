package com.fea.notification;

import com.fea.notification.constant.ConfigConstant;
import com.fea.notification.model.CreationLeaveNotification;
import com.fea.notification.service.SenderMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CreationLeaveKafkaListener {

    private final SenderMailService senderMailService;


    @KafkaListener(topics = ConfigConstant.LEAVE_MANAGEMENT_CREATION_NOTIFICATION_TOPIC, groupId = "groupId")
    void creationLeaveListener(CreationLeaveNotification creationLeaveNotification){
        // testing that data is coming from leave-management microservice
        System.out.println("------------------------Notification event coming from leave-management microservice -------------------------------------");
        System.out.println(creationLeaveNotification);

        // get supervisor email from employee microservice depending on employee Id coming from leave-management microservice

        // add code to send email notification for creation leave request case
        this.senderMailService.sendMail("abdo.sybari@gmail.com", "New Leave Request", "A new leave request added by "
                +creationLeaveNotification.idEmployee()+" starting from date : "+creationLeaveNotification.startDate()+ " to "+ creationLeaveNotification.endDate());
    }
}
