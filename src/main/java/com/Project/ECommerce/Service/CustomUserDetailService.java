package com.Project.ECommerce.Service;


import com.Project.ECommerce.Model.CustomUserDetail;
import com.Project.ECommerce.Model.User;
import com.Project.ECommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository UR;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = UR.findUserByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("User Not Found!"));
        return user.map(CustomUserDetail::new).get();
    }
}
