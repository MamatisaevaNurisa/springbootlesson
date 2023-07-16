package service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements UserDetailsService{
@Autowired
    private UserRepository userRepository;

public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException{
    return userRepository.findByUsername(username).orElse Throw(()->new UsernameNotFoundException("User not found")
}





}
