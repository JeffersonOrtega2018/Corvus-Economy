package com.finanzas.service;

import com.finanzas.dto.LoginRequestDto;
import com.finanzas.dto.LoginResponseDto;
import com.finanzas.dto.SignupRequestDto;
import com.finanzas.exception.IncorrectRequestException;
import com.finanzas.entities.ERole;
import com.finanzas.entities.Role;
import com.finanzas.entities.User;
import com.finanzas.repository.RoleRepository;
import com.finanzas.repository.UserRepository;
import com.finanzas.security.jwt.JwtUtils;
import com.finanzas.security.services.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;


    @Transactional
    public User registerUser(SignupRequestDto signupRequestDto) {
        if (userRepository.existsByUsername(signupRequestDto.getUsername())) {
            throw new IncorrectRequestException("El nombre usuario ya existe");
        }

        if (userRepository.existsByEmail(signupRequestDto.getEmail())) {
            throw new IncorrectRequestException("El email del usuario ya existe");
        }

        // Create new user's account
        User user = new User(signupRequestDto.getUsername(),
                signupRequestDto.getEmail(),
                encoder.encode(signupRequestDto.getPassword()),
                signupRequestDto.getPhone());

        Set<String> strRoles = signupRequestDto.getRole();
        Set<Role> roles = new HashSet<>();


        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol"));

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        return userRepository.save(user);
    }


    public LoginResponseDto authenticateUser(LoginRequestDto request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return new LoginResponseDto(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }





}
