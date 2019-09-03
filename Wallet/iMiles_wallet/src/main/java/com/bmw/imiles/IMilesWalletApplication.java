package com.bmw.imiles;

import com.bmw.imiles.entity.Imiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Date;

@SpringBootApplication
@Configuration
@EnableWebSecurity
public class IMilesWalletApplication implements CommandLineRunner {


    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${imiles.in.queue}")
    String queue;


    public static void main(String[] args) {
        SpringApplication.run(IMilesWalletApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Imiles imiles =
                new Imiles();
        imiles.setArchive(false);
        imiles.setCreatedAt(new Date());
        imiles.setCreatedBy("ABCD");
        imiles.setDeleted(false);
        imiles.setGcid("1234");
        imiles.setStatus("pending");
        imiles.setLastUpdatedBy("ABC");
        imiles.setLastUpdationDate(new Date());
        imiles.setTotalImiles(1500);
        imiles.setVin("MHDE4781");
        send(imiles);
    }


    public void send(Imiles customer) {
        jmsTemplate.convertAndSend(queue, customer);
    }

    /*
     * @Autowired public void authenticationManger(AuthenticationManagerBuilder
     * builder, UserRepository userRepo) throws Exception { if(userRepo.count()==1)
     * userRepo.save(new User("user1", "user1", Arrays.asList(new Role("USER"), new
     * Role("ACTUATOR")))); builder.userDetailsService(userName -> new
     * CustomUserDetails(userRepo.findByUserName(userName)) ); }
     */


}
