package com.memorynotfound.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    private static Logger log = LoggerFactory.getLogger(EmailService.class);
    public void sendSimpleMessage(Mail mail) throws MessagingException {
    	
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject(mail.getSubject());
        helper.setText(mail.getContent());
        helper.setTo(mail.getTo());
        helper.setFrom(mail.getTo());
        //helper.addCc(cc);
        helper.addAttachment("attachment-document-name.rar", new ClassPathResource("bookmarkfolder.rar"));
        log.debug("memorynotfound-logo.jpg adding attach"+mail);
        emailSender.send(message);

    }

}
