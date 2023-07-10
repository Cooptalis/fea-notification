package com.fea.notification.model;

import java.time.LocalDateTime;
import java.util.UUID;


public final record CreationLeaveNotification(UUID idEmployee, LocalDateTime startDate, LocalDateTime endDate) {
}
