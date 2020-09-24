package com.udemy.backendninja.crudcontacts.service.impl;

import com.udemy.backendninja.crudcontacts.entity.UserEntity;
import com.udemy.backendninja.crudcontacts.entity.UserRoleEntity;
import com.udemy.backendninja.crudcontacts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("UserService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("UserRepository")
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(userName);
        return this.buildUser(userEntity, buildAuthorities(userEntity.getUserRole()));
    }

    public User buildUser(UserEntity user, List<GrantedAuthority> listAuthorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true,
                true, true, listAuthorities);
    }

    public List<GrantedAuthority> buildAuthorities(Set<UserRoleEntity> listUserRole) {
        Set<GrantedAuthority> listAuthorities = new HashSet<>();
        for (UserRoleEntity userRole : listUserRole) {
            listAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<>(listAuthorities);
    }
}
