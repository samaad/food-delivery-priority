package org.assignment.food.servic;

import lombok.extern.log4j.Log4j2;
import org.assignment.food.modal.MyUserDetails;
import org.assignment.food.modal.entity.User;
import org.assignment.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found: "+ userName));
        return user.map(MyUserDetails::new).get();

    }
}