package com.eldorado.msnotification.service;

import com.eldorado.msnotification.dto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    private final ObjectMapper objectMapper;

    private final ModelMapper modelMapper;

    public void sendEmail(final String message) throws JsonProcessingException {

        final var messageDto = objectMapper.readValue(message, MessageDto.class);

        final SimpleMailMessage simpleMailMessage = modelMapper.map(messageDto, SimpleMailMessage.class);
        simpleMailMessage.setText(messageDto.getMessage());
        simpleMailMessage.setFrom("noreply@hsti.eng.br");

        javaMailSender.send(simpleMailMessage);
    }
}
