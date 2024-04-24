package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@RestController
@RequestMapping("/api/user")
public class UserControllerRest {
    private final UserService userService;
    @Autowired

    public UserControllerRest(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<User> getUser(Principal principal) {
        return ResponseEntity.ok( userService.getUserByEmail(principal.getName()));
//        return ResponseEntity.ok(user);


//@GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//public ResponseEntity<String> getUser(Principal principal) {
//    // Предположим, что у вас есть метод, который возвращает HTML-строку
//    String htmlContent = userService.getUserHtmlContent(principal.getName());
//    return ResponseEntity.ok()
//            .contentType(MediaType.TEXT_HTML)
//            .body(htmlContent);
//}
    }





}
