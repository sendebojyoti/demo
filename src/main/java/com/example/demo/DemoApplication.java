package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@RestController
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

@Component
class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private BlockingCallService blockingCallController;

    @Override
    public void run(String... args) throws Exception {
        int i = 0, j = 0;
        do {
            blockingCallController.webClientBlockingCall();
            i++;
        } while (i <= 100);

        do {
            blockingCallController.restTemplateBlockingCall();
            j++;
        } while (j <= 100);
    }
}
