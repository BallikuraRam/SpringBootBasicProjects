package com.jwtauthentication;

import com.jwtauthentication.domain.User;
import com.jwtauthentication.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class JwtAuthenticationApplication {
//    private final UserRepository userRepository ;
//    @PostConstruct
//    public void initUsers() {
//        List<User> users = Stream.of(
//                new User(101, "javatechie", "password", "javatechie@gmail.com"),
//                new User(102, "user1", "pwd1", "user1@gmail.com"),
//                new User(103, "user2", "pwd2", "user2@gmail.com"),
//                new User(104, "user3", "pwd3", "user3@gmail.com")
//        ).collect(Collectors.toList());
//        userRepository.saveAll(users);
//    }
    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationApplication.class, args);
    }

}
