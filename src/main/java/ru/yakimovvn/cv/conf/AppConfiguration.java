package ru.yakimovvn.cv.conf;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Create by Vladimir Yakimov on 04.09.2022
 * cv
 **/

@Configuration
@EnableCaching
public class AppConfiguration {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("jobs", "educations", "languages", "contacts", "skills") {
            @Override
            protected Cache createConcurrentMapCache(final String name) {
                return new ConcurrentMapCache(name,
                        CacheBuilder.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES).maximumSize(100).build().asMap(), false);
            }
        };
    }

    @Bean
    public JavaMailSender getJavaMailSender(@Value("${spring.mail.host}") String mailPost, @Value("${spring.mail.port}") int mailPort, @Value("${spring.mail.username}") String username, @Value("${spring.mail.password}") String password) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailPost);
        mailSender.setPort(mailPort);

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
