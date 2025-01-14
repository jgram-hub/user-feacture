package kr.project.userfeature.verify.strategy;

import kr.project.userfeature.verify.domain.code.VerifyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Slf4j
@RequiredArgsConstructor
@Component(VerifyType.EMAIL_VERIFY_BEAN)
public class VerifyEmailSender implements VerifyTypeStrategy {

    private final JavaMailSender javaMailSender;

    @Async
    @Override
    public void send(String verifyTypeValue, String verifyNumber) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(verifyTypeValue);
        mailMessage.setSubject("인증번호가 발송되었습니다");
        mailMessage.setText(MessageFormat.format("인증번호는 [{0}]입니다", verifyNumber));
        javaMailSender.send(mailMessage);
    }
}