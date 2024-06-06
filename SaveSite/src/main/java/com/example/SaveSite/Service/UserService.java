package com.example.SaveSite.Service;

import com.example.SaveSite.Entity.JwtUtil;
import com.example.SaveSite.Repository.UserRepository;
import com.example.SaveSite.Entity.User;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final JwtUtil jwtUtil;
    private final ApplicationContext applicationContext;
    private AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository repository, JwtUtil jwtUtil, ApplicationContext applicationContext) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
        this.applicationContext = applicationContext;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with login: " + login);
        }
        return user;
    }

    public String authenticateUser(String login, String password) throws Exception {
        if (authenticationManager == null) {
            authenticationManager = applicationContext.getBean(AuthenticationManager.class);
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        } catch (Exception e) {
            throw new Exception("Invalid credentials");
        }
        final UserDetails userDetails = loadUserByUsername(login);
        return jwtUtil.generateToken(userDetails);
    }

    public void save(String login, String email, String password) {
        try {
            LocalDateTime now = LocalDateTime.now();
            User user = new User(login, email, password, now);
            this.repository.save(user);
        } catch (DuplicateKeyException e) {
            throw new IllegalArgumentException("Login ou email ja existem");
        } catch (Exception e) {
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    public User findUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    public Optional<User> findUserById(String userId) {
        return repository.findById(userId);
    }

    public User updateUser(String userId, String login, String email, String password) {
        Optional<User> userOptional = repository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if(!Objects.equals(login, "")) {
                user.setLogin(login);
            }
            if(!Objects.equals(email, "")) {
                user.setEmail(email);
            }
            if(!Objects.equals(password, "")) {
                user.setPassword(password);
            }
            return repository.save(user);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    public void deleteUserById(String userId) {
        repository.deleteById(userId);
    }
}
