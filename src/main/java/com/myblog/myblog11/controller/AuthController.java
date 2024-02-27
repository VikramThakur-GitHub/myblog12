package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Role;
import com.myblog.myblog11.entity.User;
import com.myblog.myblog11.payload.LoginDto;
import com.myblog.myblog11.payload.SignUpDto;
import com.myblog.myblog11.repository.RoleRepository;
import com.myblog.myblog11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;     // This has username and password coming from database.
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

   /* Or generate Constructor instead of @Autowired .
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }*/

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword());

        // authenticationManager has usernanme and password from the database and the usernamePasswordAuthenticationToken has username and password from the user.
        // authenticate method is used to compare both and returns a token like True/False.
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //Now we create session variable after login.
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("User signed in successfully!", HttpStatus.OK);
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
        if (userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username already taken !", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email already taken !", HttpStatus.BAD_REQUEST);
        }
        User user= new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName(signUpDto.getRoleType()).get();

        // Convert roles object to a set.
        Set<Role> convertRoleToSet = new HashSet<>();
        convertRoleToSet.add(roles);
        user.setRoles(convertRoleToSet);

        // Another way to convert by using collections.
        // user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User Registered Successfully.", HttpStatus.OK);
    }



}













