package com.lrpa.app.persistance.entity;

import com.lrpa.app.enums.Role;
import com.lrpa.app.persistance.entity.audit.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ROMULO
 * @package com.lrpa.app.persistance.entity
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */

@Table(name = "users")
@Entity @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends Audit implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null
    private Long id;
    private String name;
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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
