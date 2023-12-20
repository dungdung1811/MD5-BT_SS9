package com.ra.scurity;
import com.ra.model.Users;
import com.ra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
        Users users = userRepository.findByUserName(username);
        List<GrantedAuthority> grantedAuthorities = users.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return  new UserPrinciple(users.getId(),users.getUserName(),users.getPassword(),users.getEmail(),users.getStatus(),grantedAuthorities);

    }
}
