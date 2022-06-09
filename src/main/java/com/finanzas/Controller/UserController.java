package com.finanzas.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.finanzas.Service.UserService;
import com.finanzas.entities.Role;
import com.finanzas.entities.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping()
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("rol/save")
    public ResponseEntity<Role>saveRol(@RequestBody Role rol){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/rol/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRol(rol));
    }

    @PostMapping("rol/addtouser")
    public ResponseEntity<?>addRolToUser(@RequestBody RolToUserForm form){
        userService.addRolToUser(form.getEmail(),form.getRolName());
        return ResponseEntity.ok().build();
    }

    
}

@Data
    class RolToUserForm{
        private String email;
        private String rolName;
    }
