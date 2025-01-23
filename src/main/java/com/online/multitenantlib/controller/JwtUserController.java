package com.online.multitenantlib.controller;

import com.online.multitenantlib.model.JwtUserDetails;
import com.online.multitenantlib.service.JwtUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class JwtUserController {

    private JwtUserService jwtUserService;

    @GetMapping
    public List<JwtUserDetails> getAllUsers() {
        return jwtUserService.getAllUsers();
    }

    @GetMapping("/{email}")
    public JwtUserDetails getUserByMail(@PathVariable String email) {
        return jwtUserService.getUserByMail(email).orElse(null);
    }

    @PostMapping
    public JwtUserDetails saveUser(@RequestBody JwtUserDetails jwtUserDetails) {
        return jwtUserService.saveUser(jwtUserDetails);
    }

    @PutMapping
    public JwtUserDetails updateUser(@RequestBody JwtUserDetails jwtUserDetails) {
        return jwtUserService.updateUser(jwtUserDetails);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody JwtUserDetails jwtUserDetails) {
        jwtUserService.deleteUser(jwtUserDetails);
    }
}
