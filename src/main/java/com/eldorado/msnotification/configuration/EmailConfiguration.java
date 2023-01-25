package com.eldorado.msnotification.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfiguration {

    @Bean
    public JavaMailSender javaMailSender() {

        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.test.br");
        mailSender.setPort(587);

        mailSender.setUsername("email@test.br");
        mailSender.setPassword("password");

        final Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");

        return mailSender;
    }
}
