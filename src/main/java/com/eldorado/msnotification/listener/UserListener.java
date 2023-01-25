package com.eldorado.msnotification.listener;

import com.eldorado.msnotification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserListener {

    private final EmailService emailService;

    @RabbitListener(queues = "${user.queue.name-create}")
    public void receive(final String message) {

        log.info("Consumer: {}", message);
    }
}
