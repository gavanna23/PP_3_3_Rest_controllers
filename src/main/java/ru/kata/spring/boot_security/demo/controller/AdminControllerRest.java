package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminControllerRest {
    private final UserService userService;
    private final RoleService roleService;

    public AdminControllerRest(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser(Principal principal) {
        return ResponseEntity.ok(userService.getUserByEmail(principal.getName()));
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

@PostMapping("/users")
public ResponseEntity<HttpStatus> addNewUser(@RequestBody User user) {
    userService.addUser(user);
    return ResponseEntity.ok(HttpStatus.CREATED);
}
    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable ("id") Long id, @RequestBody @Valid User user) {
        userService.updateUser(id, user);
        return new ResponseEntity<> (user, HttpStatus.OK);
    }

@DeleteMapping("/users/{id}")
public ResponseEntity<?> deleteUser(@PathVariable long id){
    userService.deleteUser(id);
    return ResponseEntity.ok(HttpStatus.OK);
}

}

