package com.example.SaveSite.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.time.LocalDateTime;


@Data
@Document(collection = "Users")
public class User implements UserDetails {

    @Id
    private String user_id;

    @Indexed(unique = true)
    private String login;

    @Indexed(unique = true)
    private String email;


    private String password;
    private LocalDateTime register_date;

    public User(String id, String login,String email, String password, LocalDateTime register_date) {
        this.user_id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.register_date = register_date;
    }

    public User(String login,String email, String password, LocalDateTime register_date) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.register_date = register_date;
    }

    public User(String login,String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.register_date = LocalDateTime.now();
    }

    public User() {
        this.register_date = LocalDateTime.now();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement roles/authorities if we need
        return null;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
