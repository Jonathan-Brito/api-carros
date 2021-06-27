package com.brito.carro.api.security;

import com.brito.carro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        /*User user = userRepository.findByLogin(username);

        if (user == null){
            throw new UsernameNotFoundException("user not found");
        }

            return User;
        }*/

        if (username.equals("user")){
            return User.withUsername(username).password(encoder.encode("user")).roles("USER").build();
        }
        else if (username.equals("admin")){
            return User.withUsername(username).password(encoder.encode("admin")).roles("USER", "ADMIN").build();
        }

        throw new UsernameNotFoundException("user not found");
    }
}
