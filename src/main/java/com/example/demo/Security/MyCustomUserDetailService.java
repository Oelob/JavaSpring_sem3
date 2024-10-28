package com.example.demo.Security;

import com.example.demo.models.User;
import com.example.demo.repository.UsersRepository;
import com.example.demo.repository.UsersRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MyCustomUserDetailService implements UserDetailsService {

    final UsersRepository usersRepository;
    final UsersRoleRepository usersRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByLogin(username)
                .orElseThrow(()-> new UsernameNotFoundException("Пользователь не найден"));
        List<String> userRoles = usersRoleRepository.findUserRolesByUserId(user.getId());
        List<SimpleGrantedAuthority> roles = userRoles.stream().map(SimpleGrantedAuthority::new).toList();
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
    }
}
