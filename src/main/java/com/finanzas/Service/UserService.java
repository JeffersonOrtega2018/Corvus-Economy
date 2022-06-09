package com.finanzas.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.Repositories.RolRepository;
import com.finanzas.Repositories.UserRepository;
import com.finanzas.entities.Role;
import com.finanzas.entities.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            log.error("User not found in the database");
        }else{
            log.info("User  found in the database: {}",email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRols().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }

    public User saveUser(User user){
        log.info("Saving new user to the database", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public Role saveRol(Role rol){
        log.info("Saving new rol to the database", rol.getName());
        return rolRepository.save(rol);
    }
    public void addRolToUser(String email, String rolName){
        log.info("Adding role {} to user {}", rolName, email);
        User user = userRepository.findByEmail(email);
        Role rol = rolRepository.findByName(rolName);
        user.getRols().add(rol);
    }
    public User getUser(String email){
        log.info("Fetching user {}", email);
        return userRepository.findByEmail(email);
    }
    public List<User>getUsers(){
        log.info("Fetching all users");
        return userRepository.findAll();
    }
   
}